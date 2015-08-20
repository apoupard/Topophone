import 'dart:html';
import 'package:route/client.dart';
import 'dart:js';

final Router route = new Router();
String contextUrl;
void main() {
  contextUrl = getContextUrl();
  HttpRequest.request(contextUrl + "html/sections/header", method: 'GET', requestHeaders: {'Accept': 'text/html'})
              .then((resp) {
                querySelector("#header").appendHtml(resp.responseText);
                resizeHeader();
                window.onResize.listen((event)=>resizeHeader());
              }).catchError((error) => print(error));
  
  HttpRequest.request(contextUrl + "html/sections/nav", method: 'GET', requestHeaders: {'Accept': 'text/html'})
             .then((resp) => querySelector("nav").appendHtml(resp.responseText))
             .catchError((error) => print(error));
  
  HttpRequest.request(contextUrl + "html/sections/footer", method: 'GET', requestHeaders: {'Accept': 'text/html'})
               .then((resp) => querySelector("#footer").appendHtml(resp.responseText))
               .catchError((error) => print(error));
  try {
    route..addHandler(new UrlPattern(contextUrl), showHome)
          ..addHandler(new UrlPattern(r''+contextUrl+'(.+)'), show)
          ..listen();
    
    route.gotoPath(window.location.pathname, '');
  } catch (exception, stackTrace){
    showHome('');
  }
}

String getContextUrl(){
  String pathname = window.location.pathname;
  int index = pathname.indexOf('/appli');
  if(index < 0 ) {
    return pathname;
  }
  if(index == 0 ) {
    return "/";
  }
  return pathname.substring(0, index +1);
}

void showHome(String path) {
  show(contextUrl+'html/sections/main');
}

void show(String path) {
  if(!path.contains('#')) {
    String url = path.replaceAll(new RegExp('appli'), "html/sections");
    HttpRequest.request(url, method: 'GET', requestHeaders: {'Accept': 'text/html'})
        .then((HttpRequest resp) {
          changeBackground(path);
          
          Element content = querySelector("#section")..nodes.clear()
              ..appendHtml(resp.responseText);
          
          onNewSectionDisplay();
      }
    ).catchError((error) => print(error));
  }
}

void changeBackground(String path) {
  Element background = querySelector("#background");
  background.classes.clear();
  
  int appliIndex = path.indexOf("appli/");
  if(appliIndex>=0){
    String subPath = path.substring(appliIndex + "appli/".length);
    subPath.split("/").forEach((String part) {
      if(!part.trim().isEmpty){
        querySelector("#background").classes.add(part);
      }
    });
  }
}


void resizeHeader(){
  context.callMethod('resizeHeader');
}


void onNewSectionDisplay() {
  context.callMethod('onNewSectionDisplay');
}

