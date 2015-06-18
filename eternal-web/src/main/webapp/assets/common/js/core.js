/**
 * Created by fangshuai on 2015/6/18.
 */
$(document).pjax('a, a[data-pjax]', '#pjax-container')
var isPjax = $('meta[http-equiv="X-PJAX"]').attr('content');
if(isPjax == 'true') {
    $.pjax.reload({container: '#pjax-container'})
}