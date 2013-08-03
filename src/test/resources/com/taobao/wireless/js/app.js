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

