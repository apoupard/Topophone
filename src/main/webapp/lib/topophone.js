$(document).ready(function() {
	window.contextUrl = getContextUrl();
	fillHeader();
	fillNav();
	fillFooter();
	bindRoute();
});

function bindRoute() {
	//page(window.contextUrl, showHome);
	//page(window.contextUrl + '/*', show);
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
		$(window).resize(function() {
			resizeHeader();
		});
	}).fail(function() {
		alert("error");
	});
}

function fillNav() {
	$.ajax({
		method : "GET",
		url : window.contextUrl + "/html/sections/nav",
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
		if(pathname.endsWith('/')){
			pathname = pathname.substring(0, pathname.length - 1);
		}
		return pathname;
	}
	if (index == 0) {
		return "";
	}
	return pathname.substring(0, index);
}

function onNewSectionDisplay() {
	startCarousel();
	startSoundPlayer();
	enginePerfectScrollbar();
}

function startCarousel() {
	if ($('.jcarousel').size() > 0) {
		$('.jcarousel').jcarousel({
			wrap : 'circular'
		}).jcarouselAutoscroll({
			interval : 3000,
			target : '+=1',
			autostart : true
		});
	}
}
function startSoundPlayer() {
	if ($('.sm2-bar-ui').size() > 0) {
		window.SM2BarPlayer($('.sm2-bar-ui')[0])
	}
}
function startShowVideo(url) {
	if ($('.youtubePopup').attr('data') != url) {
		$('.youtubePopup').attr('data', url);
	}
	$('.toHide.hidden').removeClass('hidden');
}

function enginePerfectScrollbar() {
	$('.column-center .widget-content').perfectScrollbar();
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
