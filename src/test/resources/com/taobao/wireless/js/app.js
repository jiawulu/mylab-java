window = {
    app: {
        definePage: function (config) {
            var PAGECONFIG = config;
            if(config.resources){
                PAGECONFIG.jsresource = config.resources.js;
                PAGECONFIG.jsresource = config.resources.css;
            }
            window.PAGECONFIG = PAGECONFIG;

            return config;
        }
    }
};

var PERL_REGEXP = /P\<([a-z0-9_-][a-z0-9_-]*?)\>/gi,
    ARGS_SPLITER = '!';
function testRoute(routeText,fragment) {
    routeText = routeText.replace(PERL_REGEXP, '');
    return new RegExp('^(' + routeText + ')(' + ARGS_SPLITER + '.*?)?$').test(fragment);
}




