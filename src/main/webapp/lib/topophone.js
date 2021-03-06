$(document).ready(function() {
	window.contextUrl = getContextUrl();
	fillHeader();
	fillNav();
	fillFooter();
	bindRoute();
	handleImageCredit();
	
	$(window).resize(function() {
		resizeHeader();
		resizeColumnCenterWidget();
	});
});

function bindRoute() {
	page('*', show);
	page({dispatch:false});
	page(window.location.pathname);
}

function fillHeader() {
	$.ajax({
		method : "GET",
		url : window.contextUrl + "/html/sections/header",
		headers : {
			'Accept' : 'text/html'
		}
	}).done(function(data) {
		$("#header").append(data);
		resizeHeader();
	}).fail(function() {
		alert("error");
	});
}

function fillNav() {
	$.ajax({
		method : "GET",
		url : window.contextUrl + "/html/sections/nav/main",
		headers : {
			'Accept' : 'text/html'
		}
	}).done(function(data) {
		$("nav").append(data);
	}).fail(function() {
		alert("error");
	});
}

function fillFooter() {
	$.ajax({
		method : "GET",
		url : window.contextUrl + "/html/sections/footer",
		headers : {
			'Accept' : 'text/html'
		}
	}).done(function(data) {
		$("#footer").append(data);
	}).fail(function() {
		alert("error");
	});
}

function showHome() {
	loadBlock(window.contextUrl + '/html/sections/main');
}

function show(ctx) {
	var path = ctx.path;
	if (path.indexOf('#') < 0) {
		if(path == window.contextUrl || path == window.contextUrl+'/') {
			loadBlock(window.contextUrl + '/html/sections/main');
		} else {
			url = path.replace(new RegExp('/appli'), "/html/sections");
			loadBlock(url);

		}
	}
}

function loadBlock(path) {
	onBeforeNewSectionDisplay();
	$.ajax({
		method : "GET",
		url : path,
		headers : {'Accept' : 'text/html'}
	}).done(function(data) {
		changeBackground(path);
		$('#section').empty();
		$('#section').append(data);
		onNewSectionDisplay();
	}).fail(function() {
		alert("error");
	});
}

function changeBackground(path) {
	var background = $("#background");
	background.removeClass();
	var appliIndex = window.location.pathname.indexOf("appli/");
	if (appliIndex >= 0) {
		var subPath = window.location.pathname.substring(appliIndex + "appli/".length);
		subPath.split("/").forEach(function(part) {
			if (part.trim().length > 0) {
				$("#background").addClass(part);
			}
		});
	}
}

function getContextUrl() {
	var pathname = window.location.pathname;
	var index = pathname.indexOf('/appli');
	if (index < 0) {
		if(endsWith(pathname, '/')){
			pathname = pathname.substring(0, pathname.length - 1);
		}
		return pathname;
	}
	if (index == 0) {
		return "";
	}
	return pathname.substring(0, index);
}

function onBeforeNewSectionDisplay() {
	stopSoundPlayer();
}

function onNewSectionDisplay() {
	startCarousel();
	startSoundPlayer();
	enginePerfectScrollbar();
	handleImageCredit();
	resizeColumnCenterWidget();
}

function startCarousel() {
	if ($('.jcarousel-auto').size() > 0) {
		$('.jcarousel-auto').jcarousel({
			wrap : 'circular'
		}).jcarouselAutoscroll({
			interval : 3000,
			target : '+=1',
			autostart : true
		});
	}
	
	if ($('.jcarousel-manual').size() > 0) {
		$('.jcarousel-manual').jcarousel({
			wrap : 'circular'
		});
	}
	
	$('.jcarousel-control-next').jcarouselControl({
        target: '+=1'
    });
	$('.jcarousel-control-previous').jcarouselControl({
        target: '-=1'
    });

}
function startSoundPlayer() {
	if ($('.sm2-bar-ui').size() > 0) {
		window.SM2BarPlayer($('.sm2-bar-ui')[0]);
	}
}

function stopSoundPlayer() {
	if (typeof soundManager != 'undefined') {
		soundManager.stopAll();
	}
}

function stopSoundPlayer() {
	if (typeof soundManager != 'undefined') {
		soundManager.stopAll();
	}
}

function pauseSoundPlayer() {
	if (typeof soundManager != 'undefined') {
		soundManager.pauseAll();
	}
}


function startShowVideo(url) {
	pauseSoundPlayer();
	if ($('.youtubePopup').attr('data') != url) {
		$('.youtubePopup').attr('data', url);
	}
	$('.toHide.hidden').removeClass('hidden');
}

function enginePerfectScrollbar() {
	$('.column-center .widget-content').perfectScrollbar();
	$('.perfect-scrollbar .widget-content').perfectScrollbar();
}

function resizeHeader() {
	var all = $("#header #all");
	var deco = $("#header #deco");
	var left = $("#header #decoLeft");
	var rigth = $("#header #decoRight");

	var sideSize = ((window.innerWidth - deco.width() - 4) / 2) + 2;
	if (sideSize < 0) {
		sideSize = 0;
	}
	left.width(sideSize);
	rigth.width(sideSize);

}

function handleImageCredit() {
	$(".hasCredit").mouseover(function() {
		$(this).find(".credit").removeClass('hidden');
	});
	
	$(".hasCredit").mouseout(function(elem) {
		$(this).find(".credit").addClass('hidden');
	});
}

function endsWith(value, suffix){
	  return value.indexOf(suffix, value.length - suffix.length) !== -1;
}

function resizeColumnCenterWidget(){
	var headerHeight = $("#header").height();
	var siteMarginTop = 115;
	var siteMarginBottom = 30;
	var siteMarginHeight = $("#site").height();
	var spaceleft = window.innerHeight - ((headerHeight - siteMarginTop) + siteMarginHeight + siteMarginBottom )
	var widgetContent = $('.column-center .widget-content');
	var middleWidget = $(".column-center .widget");
	if(spaceleft > 0 && hasScrollBar(widgetContent) ) {
		var newSize = getNewSize(widgetContent, middleWidget, spaceleft);
		middleWidget.height(newSize);
	} else if(spaceleft < 0) {
		var minSize = 450;
		var newSize = middleWidget.height() + spaceleft;
		if(newSize < minSize) {
			middleWidget.height(minSize);
		} else {
			middleWidget.height(newSize);
		}
	}
}

function hasScrollBar(widgetContent){
	return widgetContent[0].scrollHeight > widgetContent.height();
}

function getNewSize(widgetContent, middleWidget, spaceleft){
	var newSize = middleWidget.height() + spaceleft;
	var scrollSize = widgetContent[0].scrollHeight;
	if(scrollSize > newSize) {
		return newSize;
	} else {
		return scrollSize;
	}
}