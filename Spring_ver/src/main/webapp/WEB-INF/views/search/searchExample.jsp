<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>

<!-- ======= Breadcrumbs ======= -->
        <section class="breadcrumbs">
            <div class="container">

                <div class="d-flex justify-content-between align-items-center">
                    <h2>SEARCH</h2>
                    <ol>
                        <li><a href="index.html">Home</a></li>
                        <li>SEARCH</li>
                    </ol>
                </div>

            </div>
        </section><!-- End Breadcrumbs -->

        <div class="container">
            <div style="height: 50px;"></div>
            <div class="row">
                <div class="col-sm-5">
                    <h5 class="mt-2 mb-4"> Please select the region you want to search.</h5>
                    <div class="row mb-2">
                        <div class="col">
                            <form action="">
                                <select name="cars" style="width: 100%; height: 30px;">
                                    <option selected>서울특별시</option>
                                </select>
                            </form>
                        </div>
                        <div class="col">
                            <form action="">
                                <select name="cars" style="width: 100%; height: 30px;">
                                    <option selected>종로구</option>
                                </select>
                            </form>
                        </div>
                    </div>
                    <div class="row" style="margin-bottom: 10px;">
                        <div class="col">
                            <form action="">
                                <select name="cars" style="width: 100%; height: 30px;">
                                    <option selected>창신동</option>
                                </select>
                            </form>
                        </div>
                        <div class="col">
                            <form action="">
                                <select name="cars" style="width: 100%; height: 30px;">
                                    <option selected>*</option>
                                </select>
                            </form>
                        </div>
                    </div>

                </div>
                <div class="col-sm-7">
                    <div id="map" style="width: 100%; height: 350px;">
                        <script type="text/javascript"
                            src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fed99f2ec8be00245007859a6caf0270"></script>
                        <script>
                            var container = document.getElementById('map');
                            var options = {
                                center: new kakao.maps.LatLng(33.450701, 126.570667),
                                level: 3
                            };
                            var map = new kakao.maps.Map(container, options);
                        </script>
                    </div>
                </div>
            </div>
            <div style="height: 50px;"></div>
            <div class="container">
                <table class="table table-hover" style="margin:20px 0">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">NAME</th>
                            <th scope="col">BUILDYEAR</th>
                            <th scope="col">DEALAMOUNT</th>
                            <th scope="col">YEAR</th>
                            <th scope="col">MONTH</th>
                            <th scope="col">LIKE</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>동대문</td>
                            <td>1966</td>
                            <td>29,000</td>
                            <td>2019</td>
                            <td>1</td>
                            <td>☆</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>동대문</td>
                            <td>1966</td>
                            <td>29,200</td>
                            <td>2019</td>
                            <td>2</td>
                            <td>☆</td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>동대문</td>
                            <td>1966</td>
                            <td>29,500</td>
                            <td>2019</td>
                            <td>7</td>
                            <td>☆</td>
                        </tr>
                        <tr>
                            <th scope="row">4</th>
                            <td>동대문</td>
                            <td>1966</td>
                            <td>28,800</td>
                            <td>2019</td>
                            <td>8</td>
                            <td>☆</td>
                        </tr>
                        <tr>
                            <th scope="row">5</th>
                            <td>동대문</td>
                            <td>1966</td>
                            <td>29,300</td>
                            <td>2019</td>
                            <td>8</td>
                            <td>☆</td>
                        </tr>
                        <tr>

                        </tr>
                        <tr>
                            <th scope="row">6</th>
                            <td>MID 그린(3동)</td>
                            <td>2002</td>
                            <td>25,400</td>
                            <td>2019</td>
                            <td>2</td>
                            <td>☆</td>
                        </tr>
                        <tr>
                            <th scope="row">7</th>
                            <td>MID 그린(3동)</td>
                            <td>2002</td>
                            <td>27,500</td>
                            <td>2019</td>
                            <td>6</td>
                            <td>☆</td>
                        </tr>
                        <tr>
                            <th scope="row">8</th>
                            <td>성용</td>
                            <td>1994</td>
                            <td>26,800</td>
                            <td>2019</td>
                            <td>2</td>
                            <td>☆</td>
                        </tr>
                        <tr>
                            <th scope="row">9</th>
                            <td>창신쌍용2</td>
                            <td>1993</td>
                            <td>53,500</td>
                            <td>2019</td>
                            <td>2</td>
                            <td>☆</td>
                        </tr>
                        <tr>
                            <th scope="row">10</th>
                            <td>두산</td>
                            <td>1999</td>
                            <td>55,500</td>
                            <td>2019</td>
                            <td>11</td>
                            <td>☆</td>
                        </tr>

                    </tbody>
                </table>
            </div>
        </div>





    </main><!-- End #main -->
<%@ include file="../inc/footer.jsp" %>