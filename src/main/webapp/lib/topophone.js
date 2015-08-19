
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
