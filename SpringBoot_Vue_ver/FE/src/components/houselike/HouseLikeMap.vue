<template>
  <div class="map_wrap">
    <div id="map"></div>
    <ul id="category">
      <li id="BK9" data-order="0" @click.prevent="addCategoryClickEvent(0)">
        <span class="category_bg bank"></span>
        은행
      </li>
      <li id="MT1" data-order="1" @click.prevent="addCategoryClickEvent(1)">
        <span class="category_bg mart"></span>
        마트
      </li>
      <li id="PM9" data-order="2" @click.prevent="addCategoryClickEvent(2)">
        <span class="category_bg pharmacy"></span>
        약국
      </li>
      <li id="OL7" data-order="3" @click.prevent="addCategoryClickEvent(3)">
        <span class="category_bg oil"></span>
        주유소
      </li>
      <li id="CE7" data-order="4" @click.prevent="addCategoryClickEvent(4)">
        <span class="category_bg cafe"></span>
        카페
      </li>
      <li id="CS2" data-order="5" @click.prevent="addCategoryClickEvent(5)">
        <span class="category_bg store"></span>
        편의점
      </li>
    </ul>
  </div>
</template>

<script>
import { mapState } from 'vuex'
const houseLikeStore = 'houseLikeStore'

export default {
  data() {
    return {
      map: null,
      positions: [],
      markers: [],

      placeMarkers: [], // 마커를 담을 배열
      currCategory: '', // 현재 선택된 카테고리를 가지고 있을 변수
      ps: null,
    }
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      // console.log("이미 로딩");
      this.initMap()
    } else {
      const script = document.createElement('script')
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap)
      script.src =
        'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=' +
        // ${process.env.VUE_APP_KAKAOMAP_API_KEY}
        'fed99f2ec8be00245007859a6caf0270' +
        '&libraries=services' // 서비스 라이브러리 추가

      document.head.appendChild(script)
    }
  },
  computed: {
    ...mapState(houseLikeStore, ['house']),
  },
  watch: {
    house: function () {
      this.markAptsOnMap()
      this.markPlaces()
    },
  },
  methods: {
    initMap() {
      const container = document.getElementById('map')
      const options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 3,
      }
      //지도 객체를 등록합니다.
      //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
      this.map = new kakao.maps.Map(container, options)
    },
    markAptsOnMap() {
      // 기존에 찍은 마커 지우기
      if (this.markers.length > 0) {
        this.markers.forEach((item) => {
          item.setMap(null)
        })
      }
      this.markers = []
      this.positions = []
      console.log('before', this.markers)

      // for (let i = 0; i < this.houses.length; i++) {
      this.positions.push({
        title: this.house.aptName,
        latlng: new kakao.maps.LatLng(this.house.lat, this.house.lng),
      })
      // }

      // 마커 이미지 생성
      var imageSrc =
        'https://cdn3.iconfinder.com/data/icons/construction-building-7/256/2-512.png'
      var imageSize = new kakao.maps.Size(35, 40)
      var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize)

      // 마커 표시
      this.positions.forEach((position) => {
        const marker = new kakao.maps.Marker({
          map: this.map, // 마커를 표시할 지도
          position: position.latlng, // 마커를 표시할 위치
          title: position.title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
          image: markerImage, // 마커 이미지
        })
        this.markers.push(marker)
        // if (index == 0) {
        //   this.map.panTo(position.latlng)
        // }
      })
      console.log('after', this.markers)

      // 지도 이동
      const bounds = this.positions.reduce(
        (bounds, position) => bounds.extend(position.latlng),
        new kakao.maps.LatLngBounds(),
      )
      this.map.panTo(bounds)
    },
    markPlaces() {
      // 장소 검색 객체 생성
      this.ps = new kakao.maps.services.Places(this.map)
      // 지도에 idle 이벤트를 등록
      kakao.maps.event.addListener(this.map, 'idle', this.searchPlaces)
    },
    // 카테고리 검색을 요청하는 함수
    searchPlaces() {
      if (!this.currCategory) {
        return
      }
      // 지도에 표시되고 있는 마커를 제거합니다
      this.removeMarker()

      this.ps.categorySearch(this.currCategory, this.placesSearchCB, {
        useMapBounds: true,
      })
    },
    // 장소검색이 완료됐을 때 호출되는 콜백함수
    placesSearchCB(data, status) {
      if (status === kakao.maps.services.Status.OK) {
        // 정상적으로 검색이 완료됐으면 지도에 마커를 표출합니다
        this.displayPlaces(data)
      } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
        // 검색결과가 없는경우 해야할 처리가 있다면 이곳에 작성해 주세요
      } else if (status === kakao.maps.services.Status.ERROR) {
        // 에러로 인해 검색결과가 나오지 않은 경우 해야할 처리가 있다면 이곳에 작성해 주세요
      }
    },
    // 지도에 마커를 표출하는 함수
    displayPlaces(places) {
      //console.log(places)
      // 몇번째 카테고리가 선택되어 있는지 얻어옵니다
      // 이 순서는 스프라이트 이미지에서의 위치를 계산하는데 사용됩니다
      // console.log(this.currCategory)
      var order = document
        .getElementById(this.currCategory)
        .getAttribute('data-order')

      for (var i = 0; i < places.length; i++) {
        // 마커를 생성하고 지도에 표시합니다
        var marker = this.addMarker(
          new kakao.maps.LatLng(places[i].y, places[i].x),
          order,
        )

        // 마커와 검색결과 항목을 클릭 했을 때
        // 장소정보를 표출하도록 클릭 이벤트를 등록합니다
        ;(function (marker, place) {
          kakao.maps.event.addListener(marker, 'click', function () {
            this.displayPlaceInfo(place)
          })
        })(marker, places[i])
      }
    },
    // 마커를 생성하고 지도 위에 마커를 표시하는 함수
    addMarker(position, order) {
      var imageSrc =
          'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(27, 28), // 마커 이미지의 크기
        imgOptions = {
          spriteSize: new kakao.maps.Size(72, 208), // 스프라이트 이미지의 크기
          spriteOrigin: new kakao.maps.Point(46, order * 36), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
          offset: new kakao.maps.Point(11, 28), // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(
          imageSrc,
          imageSize,
          imgOptions,
        ),
        marker = new kakao.maps.Marker({
          position: position, // 마커의 위치
          image: markerImage,
        })

      marker.setMap(this.map) // 지도 위에 마커를 표출합니다
      this.placeMarkers.push(marker) // 배열에 생성된 마커를 추가합니다

      return marker
    },
    removeMarker() {
      // 지도 위에 표시되고 있는 마커를 모두 제거
      for (var i = 0; i < this.placeMarkers.length; i++) {
        this.placeMarkers[i].setMap(null)
      }
      this.placeMarkers = []
    },
    // 각 카테고리의 클릭 이벤트
    addCategoryClickEvent(num) {
      var category = document.getElementById('category'),
        children = category.children

      //console.log(children[num])
      children[num].onclick = this.onClickCategory(children[num])
    },
    // 카테고리를 클릭했을 때 호출되는 함수
    onClickCategory(child) {
      var id = child.id,
        className = 1

      if (className === 'on') {
        this.currCategory = ''
        this.removeMarker()
      } else {
        this.currCategory = id
        // console.log(this.currCategory)
        this.searchPlaces()
      }
    },
  },
}
</script>

<style scoped>
.map_wrap,
.map_wrap * {
  margin: 0;
  padding: 0;
  font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;
  font-size: 12px;
}
.map_wrap {
  position: relative;
  /* width: 100%;
  height: 760px; */
}
#map {
  height: 640px;
  width: 100%;
  position: relative;
  overflow: hidden;
}
#category {
  position: absolute;
  top: 10px;
  left: 10px;
  border-radius: 5px;
  border: 1px solid #909090;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.4);
  background: #fff;
  overflow: hidden;
  z-index: 2;
}
#category li {
  float: left;
  list-style: none;
  width: 50px;
  border-right: 1px solid #acacac;
  padding: 6px 0;
  text-align: center;
  cursor: pointer;
}
#category li.on {
  background: #eee;
}
#category li:hover {
  background: #ffe6e6;
  border-left: 1px solid #acacac;
  margin-left: -1px;
}
#category li:last-child {
  margin-right: 0;
  border-right: 0;
}
#category li span {
  display: block;
  margin: 0 auto 3px;
  width: 27px;
  height: 28px;
}
#category li .category_bg {
  background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png)
    no-repeat;
}
#category li .bank {
  background-position: -10px 0;
}
#category li .mart {
  background-position: -10px -36px;
}
#category li .pharmacy {
  background-position: -10px -72px;
}
#category li .oil {
  background-position: -10px -108px;
}
#category li .cafe {
  background-position: -10px -144px;
}
#category li .store {
  background-position: -10px -180px;
}
#category li.on .category_bg {
  background-position-x: -46px;
}
</style>
