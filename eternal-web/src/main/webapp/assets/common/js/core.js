/**
 * require jquery, pjax
 * Created by fangshuai on 2015/6/18.
 */

$(document).pjax('[data-pjax] a, a[data-pjax]', '#pjax-container');
// support pjax!
var isPjax = $('meta[http-equiv="X-PJAX"]').attr('content');
if(isPjax == 'true') {
    $.pjax.reload({container: '#pjax-container'})
}

/**
 * 请求server data前
 */
$(document).on('pjax:send', function(e) {
    $('#loading').show();
});

/**
 * server data 请求完后
 */
$(document).on('pjax:complete', function() {
    $('#loading').hide();
});

