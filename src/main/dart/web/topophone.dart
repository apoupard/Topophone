import 'dart:html';
import 'package:route/client.dart';

final Router route = new Router();
String context;
void main() {
  context = getContext();
  HttpRequest.request(context + "html/sections/header", method: 'GET', requestHeaders: {'Accept': 'text/html'})
              .then((resp) {
                querySelector("#header").appendHtml(resp.responseText);
                resizeHeader();
                window.onResize.listen((event)=>resizeHeader());
  }).catchError((error) => print(error));
  
  HttpRequest.request(context + "html/sections/nav", method: 'GET', requestHeaders: {'Accept': 'text/html'})
             .then((resp) => querySelector("nav").appendHtml(resp.responseText))
             .catchError((error) => print(error));
  try {
    route..addHandler(new UrlPattern(context), showHome)
          ..addHandler(new UrlPattern(r''+context+'(.+)'), show)
          ..listen();
    
    route.gotoPath(window.location.pathname, '');
  } catch (exception, stackTrace){
    showHome('');
  }
}

void resizeHeader(){
  Element all = querySelector("#header #all");
  Element deco = querySelector("#header #deco");
  Element left = querySelector("#header #decoLeft");
  Element rigth = querySelector("#header #decoRight");
  
  var sideSize = ((window.innerWidth - deco.clientWidth-4)/2)+2;
  left.style.width = sideSize.toStringAsFixed(0)+'px';
  rigth.style.width = sideSize.toStringAsFixed(0)+'px';
  
}

String getContext(){
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
  show(context+'html/sections/main');
}

void show(String path) {
  String url = path.replaceAll(new RegExp('appli'), "html/sections");
  HttpRequest.request(url, method: 'GET', requestHeaders: {'Accept': 'text/html'})
      .then((HttpRequest resp) {
        Element content = querySelector("#section")..nodes.clear()
            ..appendHtml(resp.responseText);
    }
  ).catchError((error) => print(error));
  
  changeBackground(path);
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

