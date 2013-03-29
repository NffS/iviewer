<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@include file="/resources/design/header.jsp" %>

<a href="index"><font size="3" color="000000">На главную</font></a>
<%@ include file="/resources/design/center.jsp" %>
<style>
   textarea {
    width: 720px; /* Ширина поля в процентах */
    height: 80px; /* Высота поля в пикселах */
    resize: none; /* Запрещаем изменять размер */
   } 
  </style>

<form:form  method="POST" action="getform">
		<fieldset>
			<legend>Персональная информация</legend>
			<table width =700px>
			<tr>
			<td width=15%></td>
			<td>
        					<div class="controls form-inline">
        					<table>
						  		<tr>
						  			<td align="left" width=130>
	            			<label for="inputValue"><font size=4>имя: </font></label>
	            			</td>
	            					
	            					<td align="right" width=80>
	            			<input type="text" class="input-medium" id="inputValue" name="firstname" value="${user.getFirstName()}">
	            			</td>
								</tr>
							</table>
        					</div>
        	</td>
        	<td ROWSPAN=7>
        	<img src="resources/design/zold.jpg" width="120" height="180">
        	</td>
        	</tr>
        	<tr><td width=15%></td><td>
        					<div class="controls form-inline">
        					<table>
						  		<tr>
						  			<td align="left" width=130>
	            				<label for="inputValue"><font size=4>фамилия: </font></label>
	            				</td>
	            					
	            					<td align="right" width=80>
	            				<input type="text" class="input-medium" id="inputValue" name="surname" value="${user.getSurname()}">
        					</td>
								</tr>
							</table>
        					</div>
			</td></tr>
			<tr><td width=15%></td><td>
        					<div class="controls form-inline">
        					<table>
						  		<tr>
						  			<td align="left" width=130>
	            				<label for="inputValue"><font size=4>отчество: </font></label>
	            				</td>
	            					
	            					<td align="right" width=80>
	            				<input type="text" class="input-medium" id="inputValue" name="lastname" value="${user.getLastName()}">
        					</td>
								</tr>
							</table>
        					</div>
			</td></tr>
			<tr><td width=15%></td><td>
							<div class="controls form-inline">
							<table>
						  		<tr>
						  			<td align="left" width=130>
								<label for="f1"><font size=4>вуз: </font></label>
								</td>
	            					
	            					<td align="right" width=80>
								<select style="height:27px" class="input-medium" id="f1" onchange="filter()" name="univerid">
									<option value="0">Другое</option>
				  					<option value="1">ОНПУ</option>
				  					<option value="2">ОНУ им. Мечникова</option>
				  					<option selected value="1">${form.getUniversity().getUniversityName()}</option>
								</select>
								</td>
								</tr>
							</table>
							</div>
			</td></tr>
			<tr><td width=15%></td><td>
							<div class="controls form-inline">
							<table>
						  		<tr>
						  			<td align="left" width=130>
								<label for="f2"><font size=4>факультет: </font></label>
								</td>
	            					
	            					<td align="right" width=80>
								<select  style="height:27px" class="input-medium" id="f2" name="faculty" disabled>
									<option value="0"></option>
				  					<option value="1">ИКС</option>
				  					<option value="1">Программная инженерия</option>
				  					<option value="1">Другой</option>
				  					<option value="2">Прикладная математика</option>
				  					<option value="2">Другой</option>
				  					<option selected value="${form.getFaculty().getFacultyName()}">${form.getFaculty().getFacultyName()}</option>
								</select>
								</td>
								</tr>
							</table>
							</div>
			</td></tr>
			<tr><td width=15%></td><td>
							<div class="controls form-inline">
							<table>
						  		<tr>
						  			<td align="left" width=130>
								<label for="inputValue"><font size=4>курс: </font></label>
								</td>
	            					
	            					<td align="right" width=80>
								<select  style="height:27px" class="input-medium" id="inputValue" name="course">
				  					<option value="1">1</option>
				  					<option value="2">2</option>
				  					<option value="3">3</option>
				  					<option value="4">4</option>
				  					<option value="5">5</option>
				  					<option selected value="${form.getCourse()}">${form.getCourse()}</option>
								</select>
								</td>
								</tr>
							</table>
							</div>
		</td></tr>
		<tr><td width=15%></td><td>
		
        					<div class="controls form-inline">
        					<table>
						  		<tr>
						  			<td align="left" width=130>
	            				<label for="inputValue"><font size=4>год окончания: </font></label>
	            				</td>
	            					
	            					<td align="right" width=80>
	            				<input type="text" class="input-small" id="inputValue" name="year" value="${form.getEndYear()}">
	            				</td>
								</tr>
							</table>
        					</div>
        					
		</td></tr>
			</table>

			<legend>Контакты</legend>
			<table width =700px>
				<tr>
					<td  width=25%></td>
					<td>
						
						  <div class="controls form-inline">
						  <table>
						  		<tr>
						  			<td align="left" width=150>
	            				<label for="inputValue"><font size=4>e-mail 1: </font></label>
	            				</td>
	            					
	            					<td align="right" width=80>
	            				<input type="text" class="input-big" id="inputValue" name="email1" value="${user.getEmail()}">
	            				</td>
								</tr>
							</table>
        				  </div>
						
					<td>
				</tr>
				<tr>
					<td width=25%></td>
					<td>
						
						  <div class="controls form-inline">
						  <table>
						  		<tr>
						  			<td align="left" width=150>
	            				<label for="inputValue"><font size=4>e-mail 2: </font></label>
	            				</td>
	            					
	            					<td align="right" width=80>
	            				<input type="text" class="input-big" id="inputValue" name="email2" value="${form.getEmail2()}">
	            				</td>
								</tr>
							</table>
        				  </div>
						
					<td>
				</tr>
				<tr>
					<td  width=25%></td>
					<td>
						
						  <div class="controls form-inline">
						  <table>
						  		<tr>
						  			<td align="left" width=150>
	            				<label for="inputValue"><font size=4>телефон: </font></label>
	            				</td>
	            					
	            					<td align="right" width=80>
	            				<input type="text" class="input-big" id="inputValue" name="phone" value="${form.getPhone()}">
	            				</td>
								</tr>
							</table>
        				  </div>
						
					<td>
				</tr>
				<tr>
					<td  width=25%></td>
					<td>
						
						  <div class="controls form-inline">
						  <table>
						  		<tr>
						  			<td align="left" width=150>
	            				<label for="inputValue"><font size=4>другие контакты: </font></label>
	            				</td>
	            					
	            					<td align="right" width=80>
	            				<input type="text" class="input-big" id="inputValue" name="another_contact" value="${form.getAnotherContact()}">
	            				</td>
								</tr>
							</table>
        				  </div>
						
					<td>
				</tr>
			</table>
			<legend>Интересы</legend>
			<table>
				<tr>
					<td align="left" valign="top" nowrap>
						<font size=4>Что тебя заинтересовало? </font>
					</td>
				</tr>
				</table>
				<table width =700px>
				<tr>
					<td width=20%>
					</td>
					<td>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left" width=300>
	            				<label for="inputValue"><font size=4>учебный центр/стажировка </font></label>
	            				</td>
	            					
	            					<td align="right" width=150>
	            					<select  style="height:27px" class="input-medium" id="inputValue" name="interest_lc">
				  					<option value="да">да</option>
				  					<option value="возможно">возможно</option>
				  					<option value="нет">нет</option>
				  					<option value="хочу узнать больше"> хочу узнать больше</option>
								</select>
								</td>
								</tr>
							</table>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=20%>
					</td>
					<td>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left" width=300>
	            				<label for="inputValue"><font size=4>работа в компании NetCracker: </font></label>
	            				</td>
	            					
	            					<td align="right" width=150>
	            				<select  style="height:27px" class="input-medium" id="inputValue" name="interest_job">
				  					<option value="да">да</option>
				  					<option value="возможно">возможно</option>
				  					<option value="нет">нет</option>
				  					<option value="хочу узнать больше">хочу узнать больше</option>
								</select>
								</td>
								</tr>
							</table>
        				  </div>
						
					</td>
				</tr>
				</table>
				<table>
				<tr>
					<td align="left" valign="top" nowrap>
						<font size=4>Интересующая область деятельности </font>
					</td>
				</tr>
				</table>
				<table width =700px>
				<tr>
					<td width=20%>
					</td>
					<td>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left" width=300>
	            				<label for="inputValue"><font size=4>разработка ПО: </font></label>
	            				</td>
	            					
	            					<td align="right" width=150>
	            				<select  style="height:27px" class="input-medium" id="inputValue" name="interest_po">
				  					<option value="да">да</option>
				  					<option value="возможно">возможно</option>
				  					<option value="нет">нет</option>
				  					<option value="хочу узнать больше">хочу узнать больше</option>
								</select>
								</td>
								</tr>
							</table>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=20%>
					</td>
					<td>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left" width=300>
	            				<label for="inputValue"><font size=4>другое: </font></label>
	            				</td>
	            					
	            					<td align="right" width=150>
	            				<input type="text" class="input-medium" id="inputValue" name="interest_another">
	            				</td>
								</tr>
							</table>
        				  </div>
						
					</td>
				</tr>
				</table>
				<table>
				<tr>
					<td align="left" valign="top" nowrap>
						<font size=4>Тип работы: </font>
					</td>
				</tr>
				</table>
				<table width =700px>
				<tr>
					<td width=20%>
					</td>
					<td>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left" width=300>
	            				<label for="inputValue"><font size=4>глубокая специализация: </font></label>
	            				</td>
	            					
	            					<td align="right" width=150>
	            				<select  style="height:27px" class="input-medium" id="inputValue" name="jobtype_gc">
				  					<option value="ИКС">да</option>
				  					<option value="ИКС">возможно</option>
				  					<option value="ИКС">нет</option>
				  					<option value="ИКС">хочу узнать больше</option>
								</select>
								</td>
								</tr>
							</table>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=20%>
					</td>
					<td>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left" width=300>
	            				<label for="inputValue"><font size=4>разнообразная работа: </font></label>
	            				</td>
	            					
	            					<td align="right" width=150>
	            				<select  style="height:27px" class="input-medium" id="inputValue" name="jobtype_rj">
				  					<option value="ИКС">да</option>
				  					<option value="ИКС">возможно</option>
				  					<option value="ИКС">нет</option>
				  					<option value="ИКС">хочу узнать больше</option>
								</select>
								</td>
								</tr>
							</table>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=20%>
					</td>
					<td>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left" width=300>
	            				<label for="inputValue"><font size=4>управление персоналом: </font></label>
	            				</td>
	            					
	            					<td align="right" width=150>
	            				<select  style="height:27px" class="input-medium" id="inputValue" name="jobtype_manage">
				  					<option value="да">да</option>
				  					<option value=">возможно">возможно</option>
				  					<option value="нет">нет</option>
				  					<option value="хочу узнать больше">хочу узнать больше</option>
								</select>
								</td>
								</tr>
							</table>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=20%>
					</td>
					<td>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left" width=300>
	            				<label for="inputValue"><font size=4>продажи: </font></label>
	            				</td>
	            					
	            					<td align="right" width=150>
	            				<select  style="height:27px" class="input-medium" id="inputValue" name="jobtype_sales">
				  					<option value="да">да</option>
				  					<option value=">возможно">возможно</option>
				  					<option value="нет">нет</option>
				  					<option value="хочу узнать больше">хочу узнать больше</option>
								</select>
								</td>
								</tr>
							</table>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=20%>
					</td>
					<td>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left" width=300>
	            				<label for="inputValue"><font size=4>другое: </font></label>
	            				</td>
	            					
	            					<td align="right" width=150>
	            				<input type="text" class="input-medium" id="inputValue" name="jobtype_another">
	            				</td>
								</tr>
							</table>
        				  </div>
						
					</td>
				</tr>
			</table>
			<legend>Достоинства</legend>
			<table>
				<tr>
					<td>
						<p>
							Владение языками программирования (по шкале от 1 до 5): 1 – писал простые программы с книгой/справкой; 3 – хорошо помню синтаксис и нек. библиотеки; 5 – написал крупный проект							
						</p>
					</td>
				</tr>
			</table>
			<table width =700px>
				<tr>
				<td width=5%></td>
				
					<td width=25% align="left" valign="top">
							<div class="controls form-inline">
								<label for="inputValue"><font size=4>C++: </font></label>
								<select  style="height:27px" class="input-small" id="inputValue" name="lan_c">
				  					<option value="1">1</option>
				  					<option value="2">2</option>
				  					<option value="3">3</option>
				  					<option value="4">4</option>
				  					<option value="5">5</option>
				  					<option selected value="${form.getProgLangC()}">${form.getProgLangC()}</option>
								</select>
							</div>
						
					</td>
					<td width=25% align="left" valign="top">
						
							<div class="controls form-inline">
								<label for="inputValue"><font size=4>Java: </font></label>
								<select  style="height:27px" class="input-small" id="inputValue" name="lan_java">
				  					<option value="1">1</option>
				  					<option value="2">2</option>
				  					<option value="3">3</option>
				  					<option value="4">4</option>
				  					<option value="5">5</option>
				  					<option selected value="${form.getProgLangJava()}">${form.getProgLangJava()}</option>
								</select>
							</div>
						
					</td>
					<td width=25% align="left" valign="top">
						
							<div class="controls form-inline">
								<input type="text" class="input-small" id="inputValue">
								<select  style="height:27px" class="input-small" id="inputValue" name="lan_another1" value="${form.getProgLangOther()}">
				  					<option value="1">1</option>
				  					<option value="2">2</option>
				  					<option value="3">3</option>
				  					<option value="4">4</option>
				  					<option value="5">5</option>
				  					<option selected value=""></option>
								</select>
							</div>
						
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td>
						<p>
							Как ты оцениваешь свои знания по разделам (по шкале от 0 до 5):							
						</p>
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td width=20%>
					</td>
					<td width=700>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left" width=300>
	            				<label for="inputValue"><font size=4>сетевые технологии: </font></label>
	            				</td>
	            					
	            					<td align="right" width=150>
	            				<select  style="height:27px" class="input-small" id="inputValue" name="cs_net">
	            					<option value="0">0</option>
				  					<option value="1">1</option>
				  					<option value="2">2</option>
				  					<option value="3">3</option>
				  					<option value="4">4</option>
				  					<option value="5">5</option>
				  					<option selected value=""></option>
								</select>
								</td>
								</tr>
							</table>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=20%>
					</td>
					<td width=700>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left" width=300>
	            				<label for="inputValue"><font size=4>эффективные алгоритмы: </font></label>
	            				</td>
	            					<td align="right" width=150>
	            				<select  style="height:27px" class="input-small" id="inputValue" name="cs_algorithm">
	            					<option value="0">0</option>
				  					<option value="1">1</option>
				  					<option value="2">2</option>
				  					<option value="3">3</option>
				  					<option value="4">4</option>
				  					<option value="5">5</option>
				  					<option selected value=""></option>
								</select>
								</td>
								</tr>
							</table>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=20%>
					</td>
					<td width=700>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left" width=300>
	            				<label for="inputValue"><font size=4>ООП: </font></label>
	            				</td>
	            					
	            					<td align="right" width=150>
	            				<select  style="height:27px" class="input-small" id="inputValue" name="cs_oop">
	            					<option value="0">0</option>
				  					<option value="1">1</option>
				  					<option value="2">2</option>
				  					<option value="3">3</option>
				  					<option value="4">4</option>
				  					<option value="5">5</option>
				  					<option selected value=""></option>
								</select>
								</td>
								</tr>
							</table>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=20%>
					</td>
					<td width=700>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left" width=300>
	            				<label for="inputValue"><font size=4>базы данных: </font></label>
	            				</td>
	            					
	            					<td align="right" width=150>
	            				<select  style="height:27px" class="input-small" id="inputValue" name="cs_bd">
	            					<option value="0">0</option>
				  					<option value="1">1</option>
				  					<option value="2">2</option>
				  					<option value="3">3</option>
				  					<option value="4">4</option>
				  					<option value="5">5</option>
				  					<option selected value=""></option>
								</select>
								</td>
								</tr>
							</table>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=20%>
					</td>
					<td width=700>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left" width=300>
	            				<label for="inputValue"><font size=4>Web: </font></label>
	            				</td>
	            					
	            					<td align="right" width=150>
	            				<select  style="height:27px" class="input-small" id="inputValue" name="cs_web">
	            					<option value="0">0</option>
				  					<option value="1">1</option>
				  					<option value="2">2</option>
				  					<option value="3">3</option>
				  					<option value="4">4</option>
				  					<option value="5">5</option>
				  					<option selected value=""></option>
								</select>
								</td>
								</tr>
							</table>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=20%>
					</td>
					<td width=700>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left"  width=300>
	            				<label for="inputValue"><font size=4>графический интерфейс (не Web): </font></label>
	            				</td>
	            					
	            					<td align="right" width=150>
	            				<select  style="height:27px" class="input-small" id="inputValue" name="cs_gui">
	            					<option value="0">0</option>
				  					<option value="1">1</option>
				  					<option value="2">2</option>
				  					<option value="3">3</option>
				  					<option value="4">4</option>
				  					<option value="5">5</option>
				  					<option selected value=""></option>
								</select>
								</td>
								</tr>
							</table>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=20%>
					</td>
					<td width=700>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left"  width=300>
	            						<label for="inputValue"><font size=4>сетевое программирование: </font></label>
	            					</td>
	            					
	            					<td align="right" width=150>
			            				<select  style="height:27px" class="input-small" id="inputValue" name="cs_netprog">
			            					<option value="0">0</option>
						  					<option value="1">1</option>
						  					<option value="2">2</option>
						  					<option value="3">3</option>
						  					<option value="4">4</option>
						  					<option value="5">5</option>
						  					<option selected value=""></option>
										</select>
									</td>
								</tr>
							</table>
        				  </div>
					</td>
				</tr>
				<tr>
					<td width=20%>
					</td>
					<td width=700>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left" width=300>
	            						<label for="inputValue"><font size=4>проектирование программ: </font></label>
	            					</td>
	            					
	            					<td align="right" width=150>
			            				<select  style="height:27px" class="input-small" id="inputValue" name="cs_design">
			            					<option value="0">0</option>
						  					<option value="1">1</option>
						  					<option value="2">2</option>
						  					<option value="3">3</option>
						  					<option value="4">4</option>
						  					<option value="5">5</option>
						  					<option selected value=""></option>
										</select>
									</td>
								</tr>
							</table>
        				  </div>
					</td>
				</tr>
				<tr>
					<td width=20%>
					</td>
					<td width=700>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left" width=300>
	            				<input type="text" class="input-big" id="inputValue">
	            				</td>
	            					
	            					<td align="right" width=150>
	            				<select  style="height:27px" class="input-small" id="inputValue" name="cs_another">
	            					<option value="0">0</option>
				  					<option value="1">1</option>
				  					<option value="2">2</option>
				  					<option value="3">3</option>
				  					<option value="4">4</option>
				  					<option value="5">5</option>
				  					<option selected value=""></option>
								</select>
								</td>
								</tr>
							</table>
        				  </div>
						
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td>
						Уровень английского языка (от 1 = elementary до 5 = advanced): 
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td width=20%>
					</td>
					<td width=700>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left" width=300>
	            				<label for="inputValue"><font size=4>чтение: </font></label>
	            				</td>
	            					
	            					<td align="right" width=150>
	            				<select  style="height:27px" class="input-small" id="inputValue" name="eng_reading">
				  					<option value="1">1</option>
				  					<option value="2">2</option>
				  					<option value="3">3</option>
				  					<option value="4">4</option>
				  					<option value="5">5</option>
				  					<option selected value=""></option>
								</select>
								</td>
								</tr>
							</table>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=20%>
					</td>
					<td width=700>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left" width=300>
	            				<label for="inputValue"><font size=4>письмо: </font></label>
	            				</td>
	            					<td align="right" width=150>
	            				<select  style="height:27px" class="input-small" id="inputValue" name="eng_writting">
				  					<option value="1">1</option>
				  					<option value="2">2</option>
				  					<option value="3">3</option>
				  					<option value="4">4</option>
				  					<option value="5">5</option>
				  					<option selected value=""></option>
								</select>
								</td>
								</tr>
							</table>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=20%>
					</td>
					<td width=700>
						  <div class="controls form-inline">
						  	<table>
						  		<tr>
						  			<td align="left" width=300>
	            				<label for="inputValue"><font size=4>устная речь: </font></label>
	            				</td>
	            					<td align="right" width=150>
	            				<select  style="height:27px" class="input-small" id="inputValue" name="eng_speaking">
				  					<option value="1">1</option>
				  					<option value="2">2</option>
				  					<option value="3">3</option>
				  					<option value="4">4</option>
				  					<option value="5">5</option>
				  					<option selected value=""></option>
								</select>
								</td>
								</tr>
							</table>
        				  </div>
						
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td width=10%>
					</td>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>Откуда ты узнал о наборе в учебный центр? </font></label>
	            				<select  style="height:27px" class="input-big" id="inputValue" name="source">
				  					<option value="в интернетах прочитал">в интернетах прочитал</option>
				  					<option value="друзья рассказали">друзья рассказали</option>
				  					<option value="Бровков посоветовал">Бровков посоветовал</option>
				  					<option value="флаер увидел">флаер увидел</option>
				  					<option value="какой учебный центр?">какой учебный центр?</option>
				  					<option selected value=""></option>
								</select>
        				  </div>
						
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td>
						Если у тебя уже есть опыт работы и/или выполненные учебные проекты, опиши их
					</td>
				</tr>
				<tr>
					<td>
						<textarea maxlength="420" name="experience">${form.getExperience()}</textarea>
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td>
						Почему тебя обязательно надо взять в NetCracker (важные достоинства; возможно, обещания =))
					</td>
				</tr>
				<tr>
					<td>
						<textarea maxlength="420" name="promises">${form.getMotivation_comment()}</textarea>
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td>
						Дополнительные сведения о себе: олимпиады, поощрения, курсы, сертификаты, личные качества, др.
					</td>
				</tr>
				<tr>
					<td>
						<textarea maxlength="420" name="more_information">${form.getComment2()}</textarea>
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td width=42%>
					</td>
					<td>
						<input type="submit" style="height:30px; width:300px; font-size: 15px" value="Жми кнопку @ почту проверяй">
					</td>
				</tr>
			</table>
		</fieldset>
</form:form>
<br><br><br><br>

<script type="text/javascript">

    function filter(_id){
        var f1 = document.getElementById("f1");
        var f2 = document.getElementById("f2");
		
		
		if(f1.value == 0) {
			f2.disabled = 1; 
		}else{		
			f2.disabled = 0;
		
			for (var r = 0; r < f2.options.length;  r++){
				if(f2.options[r].value != f1.value){ 
					f2.options[r].style.display = "none";
				}else {
					f2.options[r].style.display = "";
				}
			}
		}
    }
</script>

<font color="#FF0000" id="error" size="15px">${message }</font>

<%@ include file="/resources/design/footer.jsp" %>