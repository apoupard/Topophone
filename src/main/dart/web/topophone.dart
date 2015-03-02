import 'dart:html';
import 'package:route/client.dart';

final Router route = new Router();
String context;
void main() {

  context = getContext();
  HttpRequest.request(context + "html/header", method: 'GET', requestHeaders: {'Accept': 'text/html'})
               .then((resp) => querySelector("#header").appendHtml(resp.responseText))
               .catchError((error) => print(error));
  
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
  HttpRequest.request(context+'html/main', method: 'GET', requestHeaders: {'Accept': 'text/html'})
      .then((HttpRequest resp) {
        Element content = querySelector("#content")..nodes.clear()
            ..appendHtml(resp.responseText);
    }
  ).catchError((error) => print(error));
}

void show(String path) {
  String url = path.replaceAll(new RegExp('appli'), "html/sections");
  HttpRequest.request(url, method: 'GET', requestHeaders: {'Accept': 'text/html'})
      .then((HttpRequest resp) {
        Element content = querySelector("#content")..nodes.clear()
            ..appendHtml(resp.responseText);
    }
  ).catchError((error) => print(error));
}
