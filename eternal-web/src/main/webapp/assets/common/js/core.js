/**
 * Created by fangshuai on 2015/6/18.
 */
$(document).pjax('[data-pjax] a, a[data-pjax]', '#pjax-container')
/* support pjax! */
var isPjax = $('meta[http-equiv="X-PJAX"]').attr('content');
if(isPjax == 'true') {
    $.pjax.reload({container: '#pjax-container'})
}
$(document).on('pjax:send', function() {
    console.log('dddd');
});
$(document).on('pjax:complete', function() {
    console.log('aaa');
});