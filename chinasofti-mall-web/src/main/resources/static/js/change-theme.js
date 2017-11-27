/** 
 * easyUI更换主题
 */  
function changeTheme(themeName){  
    var themeCSS = $("#easyuiTheme");  
    var url = themeCSS.attr('href');  
    console.info(url)
    var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';  
    themeCSS.attr('href', href);  
    var iframe = $('iframe');  
    if(iframe.length > 0){  
        for(var i = 0; i < iframe.length; i++){  
            var ifr = iframe[i];  
            $(ifr).contents().find('#easyuiTheme').attr('href', href);  
        }  
    }  
    $.cookie('easyuiThemeName', themeName,{  
             //记住cookie的天数  
             expires: 7  
    });
}  

if($.cookie('easyuiThemeName')){  
    changeTheme($.cookie('easyuiThemeName'));  
} 