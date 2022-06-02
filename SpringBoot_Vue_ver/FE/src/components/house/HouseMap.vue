<template>
  <div id="map" class="mt-2"></div>
</template>

<script>
import { mapState } from 'vuex'
const houseStore = 'houseStore'

export default {
  data() {
    return {
      map: null,
      positions: [],
      markers: [],
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
        'fed99f2ec8be00245007859a6caf0270'

      document.head.appendChild(script)
    }
  },

  computed: {
    ...mapState(houseStore, ['houses', 'isDone']),
  },

  watch: {
    isDone: function () {
      this.markAptsOnMap()
    },
  },

  methods: {
    initMap() {
      const container = document.getElementById('map')
      const options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 2,
      }
      //지도 객체를 등록합니다.
      //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
      this.map = new kakao.maps.Map(container, options)
    },
    markAptsOnMap() {
      console.log('아파트 마커 표시')

      // 기존에 찍은 마커 지우기
      if (this.markers.length > 0) {
        this.markers.forEach((item) => {
          item.setMap(null)
        })
      }
      this.markers = []
      this.positions = []
      console.log('before', this.markers)

      for (let i = 0; i < this.houses.length; i++) {
        this.positions.push({
          title: this.houses[i].aptName,
          latlng: new kakao.maps.LatLng(this.houses[i].lat, this.houses[i].lng),
        })
      }

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
  },
}
</script>

<style>
#map {
  height: 640px;
  width: 100%;
}
</style>
