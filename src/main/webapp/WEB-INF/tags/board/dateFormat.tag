<%@tag import="java.util.Locale"%>
<%@tag import="java.text.SimpleDateFormat"%>
<%@ tag language="java" pageEncoding="UTF-8" body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="wridate" required="true" type="java.util.Date" %>
<%@ attribute name="check"%>
<% 
String list = "yyyy-MM-dd HH:mm EEE";
Locale loc = Locale.US;
if(check!=null)
switch(check) {
case "show":
	list = "yyyy년 MM월 dd일 E요일 a HH시 mm분";
	loc = Locale.KOREA;
	break;
case "reply":
	list = "yy.MM.dd HH:mm";
	break;
default:
}


SimpleDateFormat sdf = new SimpleDateFormat(list, loc);
%>
<%= sdf.format(wridate) %>
