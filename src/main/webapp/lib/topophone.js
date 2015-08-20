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
