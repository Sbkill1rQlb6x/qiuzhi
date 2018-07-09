<%@include file="/WEB-INF/views/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- banner -->
<div class="banner">
    <div class="am-g am-container">
        <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">

            <div data-am-widget="slider" class="am-slider am-slider-default"
                 data-am-slider='{&quot;animation&quot;:&quot;slide&quot;,&quot;controlNav&quot;:&quot;thumbnails&quot;}'>
                <ul class="am-slides">
                    <c:forEach begin="1" end="4">
                        <li data-thumb="imgs/ad1.jpeg">
                            <a
                                href="${pageContext.request.contextPath}/activity_show.do?activity_id=${a.activity_id}">
                                <img src="imgs/ad1.jpeg" class="am-img-responsive" style="height: 480px;"/>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>


        </div>

    </div>
</div>
<!-- banner stop -->


<!-- news -->
<div class="am-g am-container newatype">
    <div class="am-u-sm-12 am-u-md-12 am-u-lg-8 oh">
        <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default"
             style="border-bottom: 0px; margin-bottom: -10px">
            <h2 class="am-titlebar-title ">热门资讯</h2>
            <nav class="am-titlebar-nav">
                <a href="#more">more &raquo;</a>
            </nav>
        </div>

        <div data-am-widget="list_news"
             class="am-list-news am-list-news-default news">
            <div class="am-list-news-bd">
                <ul class="am-list">
                    <c:forEach items="${info}" var="i">
                        <li
                                class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left"
                                data-am-scrollspy="{animation:'fade'}">
                            <div class="am-u-sm-5 am-list-thumb">
                                <a href="${pageContext.request.contextPath}/informationShow.do?infoId=${i.info_id}">
                                    <img
                                            src="${pageContext.request.contextPath}${i.info_img}1.jpeg" alt="活动图片"/>
                                </a>

                            </div>

                            <div class=" am-u-sm-7 am-list-main">
                                <h3 class="am-list-item-hd">
                                    <a href="${pageContext.request.contextPath}/informationShow.do?infoId=${i.info_id}">${i.info_theme}</a>
                                </h3>
                                <div class="am-list-item-text">${i.info_profile}</div>
                            </div>

                        </li>
                        <div class="newsico am-fr">
                            <i class="am-icon-clock-o"><fmt:formatDate value="${i.info_date}" type="date"
                                                                       pattern="yyyy-MM-dd"/></i>
                        </div>
                    </c:forEach>

                </ul>
            </div>
        </div>
    </div>
    <div class="am-u-sm-12 am-u-md-12 am-u-lg-4">
        <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
            <h2 class="am-titlebar-title ">个人专栏</h2>
            <nav class="am-titlebar-nav">
                <a href="#more">more &raquo;</a>
            </nav>
        </div>
        <div data-am-widget="list_news"
             class="am-list-news am-list-news-default right-bg"
             data-am-scrollspy="{animation:'fade'}">
            <ul class="am-list">
                <c:forEach items="${author}" var="au">
                    <li
                            class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                        <div class="am-u-sm-4 am-list-thumb">
                            <a href="${pageContext.request.contextPath}/diaryShow.do?authorName=${au.author_name}"> <img
                                    src="images/face4.jpg" class="face"/>
                            </a>
                        </div>

                        <div class=" am-u-sm-8 am-list-main">
                            <h3 class="am-list-item-hd">
                                <a href="${pageContext.request.contextPath}/diaryShow.do?authorName=${au.author_name}">${au.author_name}</a>
                            </h3>

                            <div class="am-list-item-text">${au.author_profile}</div>
                        </div>
                    </li>
                    <%

                        int i = 1;
                        if (i < 2) {
                    %>
                    <hr data-am-widget="divider" style="" class="am-divider am-divider-default"/>
                    <% i++;
                    } %>
                </c:forEach>
            </ul>
        </div>

        <ul
                class="am-gallery am-avg-sm-1
  am-avg-md-1 am-avg-lg-1 am-gallery-default"
                data-am-gallery="{ pureview: true }">
            <c:forEach items="${activity}" var="ac">
                <li>
                    <div class="am-gallery-item">
                        <a href="${pageContext.request.contextPath}/activity_show.do?activity_id=${ac.activity_id}">
                            <img src="${pageContext.request.contextPath}${ac.activity_img}2.jpeg"
                                 alt="远方 有一个地方 那里种有我们的梦想"/>
                            <h3 class="am-gallery-title">${ac.activity_theme}</h3>
                            <div class="am-gallery-desc">
                                <div class="am-fr">${ac.activity_location}</div>
                                <div class="am-fl"><fmt:formatDate value="${ac.activity_date}" type="date"
                                                                   pattern="yyyy-MM-dd"/></div>
                            </div>
                        </a>
                    </div>
                </li>
            </c:forEach>

        </ul>

    </div>
</div>
<!-- news stop -->

<!-- gotop -->
<div data-am-widget="gotop" class="am-gotop am-gotop-fixed">
    <a href="#top" title="回到顶部"> <span class="am-gotop-title">回到顶部</span>
        <i class="am-gotop-icon am-icon-chevron-up"></i>
    </a>
</div>
<!-- gotop stop -->


<%@include file="/WEB-INF/views/footer.jsp" %>