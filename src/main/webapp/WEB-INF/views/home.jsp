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
            <h2 class="am-titlebar-title ">热门知识</h2>
            <nav class="am-titlebar-nav">
                <a href="#more">more &raquo;</a>
            </nav>
        </div>

        <%--知识点列表--%>
        <ul class="am-list am-list-striped">
            <c:forEach items="${hotkls}" var="h">
                <li>
                    <img class="am-radius" style="margin: 10px;margin-top: 15px;" alt="作者头像"
                         src="${h.user_face}"
                         width="40" height="40"/>
                    <div style="display: inline-table;">
                        <a href="kl.do?kl_id=${h.kl_id}" class="klList_a">${h.kl_title}</a>
                        <p style="font-size: 9pt;margin: 8px;">作者：${h.kl_author}&nbsp;&nbsp;|&nbsp;&nbsp;时间：<fmt:formatDate value='${h.kl_date}' pattern='yyyy-MM-dd HH:ss:mm'/></p>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="am-u-sm-12 am-u-md-12 am-u-lg-4">
        <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
            <h2 class="am-titlebar-title ">热门作者</h2>
            <nav class="am-titlebar-nav">
                <a href="#more">more &raquo;</a>
            </nav>
        </div>

        <div data-am-widget="list_news"
             class="am-list-news am-list-news-default right-bg"
             data-am-scrollspy="{animation:'fade'}">
            <ul class="am-list am-list-striped">
                <c:forEach items="${hotUsers}" var="hu">
                    <li>
                        <img class="am-radius" style="margin: 10px;margin-top: 15px;" alt="140*140"
                             src="${hu.user_face}"
                             width="40" height="40"/>
                        <div style="display: inline-table;">
                            <a href="#" class="klList_a">${hu.nickName}</a>
                            <p style="font-size: 9pt;margin: 1px;">分享知识点数：${hu.user_share_count}</p>

                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>

        <ul
                class="am-gallery am-avg-sm-1
  am-avg-md-1 am-avg-lg-1 am-gallery-default"
                data-am-gallery="{ pureview: true }">
            <c:forEach begin="1" end="3">
                <li>
                    <div class="am-gallery-item">
                        <a href="${pageContext.request.contextPath}/activity_show.do?activity_id=${ac.activity_id}">
                            <img src="imgs/ad1.jpeg"
                                 alt="远方 有一个地方 那里种有我们的梦想"/>
                            <h3 class="am-gallery-title">${ac.activity_theme}</h3>
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