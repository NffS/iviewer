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

<form  method="POST" action="getform_${request}">
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
	            			<font color="#FF0000" >&nbsp;&nbsp;${firstnameMessage }</font>
	            			</td>
	            					
	            					<td align="right" width=80>
	            			<input type="text" class="input-medium" id="inputValue" name="firstname" value="${user.getFirstName()}">
	            			
	            			</td>
								</tr>
							</table>
        					</div>
        	</td>
        	<td ROWSPAN=7>
        	<img src="${path}" width="120" height="180">
        	</td>
        	</tr>
        	<tr><td width=15%></td><td>
        					<div class="controls form-inline">
        					<table>
						  		<tr>
						  			<td align="left" width=130>
	            				<label for="inputValue"><font size=4>фамилия: </font></label>
	            				<font color="#FF0000" >&nbsp;&nbsp;${surnameMessage }</font>
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
	            				<font color="#FF0000" >&nbsp;&nbsp;${lastnameMessage }</font>
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
	            					
	            					<td align="right" width=140>
								<select style="height:27px" class="input-medium" id="f1" onchange="filter()" name="univerid">
				  					<option value="1">ОНПУ</option>
				  					<option value="2">ОНУ им. Мечникова</option>
				  					<option value="3">Другое</option>
				  					<option selected value="${form.getUniversity().getUniversityId()}">${form.getUniversity().getUniversityName()}</option>
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
									<option value="3"></option>
				  					<option value="11">ИКС</option>
				  					<option value="21">Программная инженерия</option>
				  					<option value="31">Другой</option>
				  					<option value="12">Прикладная математика</option>
				  					<option value="22">Другой</option>
				  					<option selected value="${form.getFaculty().getFacultyId()}">${form.getFaculty().getFacultyName()}</option>
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
	            				<font color="#FF0000" >&nbsp;&nbsp;${yearMessage }</font>
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
	            				<font color="#FF0000" >&nbsp;&nbsp;${email1Message }</font>
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
	            				<font color="#FF0000" >&nbsp;&nbsp;${email2Message }</font>
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
	            				<font color="#FF0000" >&nbsp;&nbsp;${phoneMessage }</font>       				
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
	            				<font color="#FF0000" >&nbsp;&nbsp;${another_contactMessage }</font>
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
	            					<select  style="height:27px" class="input-medium" id="inputValue" name="interest_tc">
				  					<option value="+">да</option>
				  					<option value="+-">возможно</option>
				  					<option value="-">нет</option>
				  					<option value="?"> хочу узнать больше</option>
				  					<option selected value="${form.getInterestTc()}">${interesttc}</option>
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
				  					<option value="+">да</option>
				  					<option value="+-">возможно</option>
				  					<option value="-">нет</option>
				  					<option value="?">хочу узнать больше</option>
				  					<option selected value="${form.getInterestNc()}">${interestnc}</option>
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
				  					<option value="+">да</option>
				  					<option value="+-">возможно</option>
				  					<option value="-">нет</option>
				  					<option value="?">хочу узнать больше</option>
				  					<option selected value="${form.getInterestTc()}">${interestpo}</option>
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
	            				<font color="#FF0000" >&nbsp;&nbsp;${interest_anotherMessage }</font>
	            				</td>
	            					
	            					<td align="right" width=150>
	            				<input type="text" class="input-medium" id="inputValue" name="interest_another" value="${form.getInterestAreaOther()}">
	            				
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
	            				<select  style="height:27px" class="input-medium" id="inputValue" name="jobtype_ds">
				  					<option value="+">да</option>
				  					<option value="+-">возможно</option>
				  					<option value="-">нет</option>
				  					<option value="?">хочу узнать больше</option>
				  					<option selected value="${form.getInterestTc()}">${interestpo}</option>
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
	            				<select  style="height:27px" class="input-medium" id="inputValue" name="jobtype_vj">
				  					<option value="+">да</option>
				  					<option value="+-">возможно</option>
				  					<option value="-">нет</option>
				  					<option value="?">хочу узнать больше</option>
				  					<option selected value="${form.getJobArVaried()}">${job_vj}</option>
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
				  					<option value="+">да</option>
				  					<option value="+-">возможно</option>
				  					<option value="-">нет</option>
				  					<option value="?">хочу узнать больше</option>
				  					<option selected value="${form.getJobArManage()}">${job_man}</option>
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
				  					<option value="+">да</option>
				  					<option value="+-">возможно</option>
				  					<option value="-">нет</option>
				  					<option value="?">хочу узнать больше</option>
				  					<option selected value="${form.getJobArSales()}">${job_sales}</option>
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
	            				<font color="#FF0000" >&nbsp;&nbsp;${jobtype_anotherMessage }</font>
	            				</td>
	            					
	            					<td align="right" width=150>
	            				<input type="text" class="input-medium" id="inputValue" name="jobtype_another" value="${form.getJobArOther()}">
	            				
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
								<input type="text" class="input-small" id="inputValue" name="lan_other" value="${form.getProgLangOther()}">
								<font color="#FF0000" >&nbsp;&nbsp;${lan_otherMessage }</font>
								<select  style="height:27px" class="input-small" id="inputValue" name="lan_other_mark">
				  					<option value="1">1</option>
				  					<option value="2">2</option>
				  					<option value="3">3</option>
				  					<option value="4">4</option>
				  					<option value="5">5</option>
				  					<option selected value="${form.getProgLangOtherMark()}">${form.getProgLangOtherMark()}</option>
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
				  					<option selected value="${form.getCsNetworkTech()}">${form.getCsNetworkTech()}</option>
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
				  					<option selected value="${form.getCsAlgorithms()}">${form.getCsAlgorithms()}</option>
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
				  					<option selected value="${form.getCsOop()}">${form.getCsOop()}</option>
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
				  					<option selected value="${form.getCsDb()}">${form.getCsDb()}</option>
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
				  					<option selected value="${form.getCsWeb()}">${form.getCsWeb()}</option>
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
				  					<option selected value="${form.getCsGui()}">${form.getCsGui()}</option>
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
						  					<option selected value="${form.getCsNetworkProg()}">${form.getCsNetworkProg()}</option>
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
						  					<option selected value="${form.getCsDesign()}">${form.getCsDesign()}</option>
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
	            				<input type="text" class="input-big" id="inputValue" value="${form.getCsOther()}" name="cs_another">
	            				<font color="#FF0000" >&nbsp;&nbsp;${cs_anotherMessage }</font>
	            				</td>
	            					
	            					<td align="right" width=150>
	            				<select  style="height:27px" class="input-small" id="inputValue" name="cs_another_mark">
	            					<option value="0">0</option>
				  					<option value="1">1</option>
				  					<option value="2">2</option>
				  					<option value="3">3</option>
				  					<option value="4">4</option>
				  					<option value="5">5</option>
				  					<option selected value="${form.getCsOtherMark()}">${form.getCsOtherMark()}</option>
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
				  					<option selected value="${form.getEnglishRead()}">${form.getEnglishRead()}</option>
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
				  					<option selected value="${form.getEnglishWrite()}">${form.getEnglishWrite()}</option>
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
				  					<option selected value="${form.getEnglishSpoken()}">${form.getEnglishSpoken()}</option>
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
				  					<option value="1">Увидел рекламу</option>
				  					<option value="2">Узнал от друга</option>
				  					<option value="3">Нашел в интернете</option>
				  					<option value="4">Другое</option>
				  					<option selected value="${form.getSource().getSourceId()}">${form.getSource().getSourceName()}</option>
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
</form>
<br><br><br><br>

<script type="text/javascript">

    function filter(_id){
        var f1 = document.getElementById("f1");
        var f2 = document.getElementById("f2");
		
		
		if(f1.value == 3) {
			f2.disabled = 1; 
		}else{		
			f2.disabled = 0;
		
			for (var r = 0; r < f2.options.length;  r++){
				if(f2.options[r].value % 10 != f1.value){ 
					f2.options[r].style.display = "none";
				}else {
					f2.options[r].style.display = "";
				}
			}
		}
    }
</script>

<font color="#FF0000" id="error">${message }</font>

<%@ include file="/resources/design/footer.jsp" %>