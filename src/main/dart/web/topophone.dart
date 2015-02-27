import 'dart:html';
import 'package:route/client.dart';

final Router route = new Router();
String context;
void main() {
  //window.location.pathname*
  
  context = getContext();
  HttpRequest.request(context + "html/header", method: 'GET', requestHeaders: {'Accept': 'text/html'})
               .then((resp) => querySelector("#header").appendHtml(resp.responseText))
               .catchError((error) => print(error));
  
  HttpRequest.request(context + "html/nav", method: 'GET', requestHeaders: {'Accept': 'text/html'})
             .then((resp) => querySelector("nav").appendHtml(resp.responseText))
             .catchError((error) => print(error));
  route..addHandler(new UrlPattern(r'/(.*)'), show)
        ..listen();
  route.gotoPath(window.location.pathname, '');
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

void show(String path) {
  String url = path.replaceAll(new RegExp('appli'), "html") + "/section";
  HttpRequest.request(url, method: 'GET', requestHeaders: {'Accept': 'text/html'})
      .then((HttpRequest resp) {
        Element content = querySelector("#content")..nodes.clear()
            ..appendHtml(resp.responseText);
    }
  ).catchError((error) => print(error));
}
