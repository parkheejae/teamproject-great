<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

</head>
<body>



<div id="myCarousel" class="carousel slide text-center" data-ride="carousel" style="width:1024px;margin-top: 20px;">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox" >
      <div class="item active">
        <img src="./img/ad/main1.jpg" alt="소스로 떠나는 아시안투어 5천원 이상 구매시 1천원 즉시할인" style="width: 1024px">
      </div>
      <div class="item">
        <img src="./img/ad/main2.jpg" alt="맛있는 농심 봉지라면 Pick 5천원이상 구매시 10% 즉시할인" style="width: 1024px">
      </div>
      <div class="item">
        <img src="./img/ad/main3.jpg" alt="유한킴벌리가 생활용품을 싹 끌어왔어요 3만원 이상 구매시 5천원 에누리" style="width: 1024px">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
         <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
          <span class="sr-only">Next</span>
    </a>
  </div>
  
  
  <script>
	// sandbox disable popups
	if (window.self !== window.top && window.name != "view1") {
		;
		window.alert = function() {/*disable alert*/
		};
		window.confirm = function() {/*disable confirm*/
		};
		window.prompt = function() {/*disable prompt*/
		};
		window.open = function() {/*disable open*/
		};
	}

	// prevent href=# click jump
	document.addEventListener("DOMContentLoaded", function() {
		var links = document.getElementsByTagName("A");
		for (var i = 0; i < links.length; i++) {
			if (links[i].href.indexOf('#') != -1) {
				links[i].addEventListener("click", function(e) {
					console.debug("prevent href=# click");
					if (this.hash) {
						if (this.hash == "#") {
							e.preventDefault();
							return false;
						} else {
							/*
							var el = document.getElementById(this.hash.replace(/#/, ""));
							if (el) {
							  el.scrollIntoView(true);
							}
							 */
						}
					}
					return false;
				})
			}
		}
	}, false);

	$('.carousel .carousel-item').each(function() {
		var next = $(this).next();
		if (!next.length) {
			next = $(this).siblings(':first');
		}
		next.children(':first-child').clone().appendTo($(this));

		for (var i = 0; i < 3; i++) {
			next = next.next();
			if (!next.length) {
				next = $(this).siblings(':first');
			}

			next.children(':first-child').clone().appendTo($(this));
		}
	});
</script>
</body>
</html>