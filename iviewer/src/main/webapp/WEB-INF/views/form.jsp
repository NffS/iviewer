<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@include file="/resources/design/header.jsp" %>

<a href="index"><font size="3" color="000000">На главную</font></a>
<%@ include file="/resources/design/center.jsp" %>
<form:form  method="POST" action="form">
		<fieldset>
			<legend>Персональная информация</legend>
			<table>
				<tr>
					<td width=30% align="left"  valign="top">
        				
        					<div class="controls form-inline">
	            				<label for="inputValue"><font size=4>Имя: </font></label>
	            				<input type="text" class="input-medium" id="inputValue" name="firstname">
        					</div>
        				
        			</td>
        			<td width=30% align="left"  valign="top">
        			
        					<div class="controls form-inline">
	            				<label for="inputValue"><font size=4>Фамилия: </font></label>
	            				<input type="text" class="input-medium" id="inputValue" name="surname">
        					</div>
        				
        			</td>
        			<td width=30% align="left" valign="top">
        				
        					<div class="controls form-inline">
	            				<label for="inputValue"><font size=4>Отчество: </font></label>
	            				<input type="text" class="input-medium" id="inputValue" name="lastname">
        					</div>
        				
        			</td>
				</tr>
				<tr>
					<td width=30% align="left" valign="top">
					
							<div class="controls form-inline">
								<label for="inputValue"><font size=4>вуз: </font></label>
								<select style="height:27px" class="input-medium" id="inputValue" name="univerid">
				  					<option value="ONPU">ОНПУ</option>
				  					<option value="ОНУ им. Мечникова">ОНУ им. Мечникова</option>
				  					<option selected value="другой">другой</option>
				  					<option value="я не студент">я не студент</option>
								</select>
							</div>
						
					</td>
					<td width=30% align="left" valign="top">
						
							<div class="controls form-inline">
								<label for="inputValue"><font size=4>факультет: </font></label>
								<select  style="height:27px" class="input-medium" id="inputValue" name="faculty">
				  					<option>ИКС</option>
				  					<option>Прикладная математика</option>
				  					<option>другой</option>
				  					<option>я не студент</option>
								</select>
							</div>
						
					</td>
					<td width=30% align="left" valign="top">
						
							<div class="controls form-inline">
								<label for="inputValue"><font size=4>курс: </font></label>
								<select  style="height:27px" class="input-medium" id="inputValue" name="course">
				  					<option>1</option>
				  					<option>2</option>
				  					<option>3</option>
				  					<option>4</option>
				  					<option>5</option>
				  					<option>я не студент</option>
								</select>
							</div>
						
					</td>
				</tr>
				<tr>
					<td>
					
        					<div class="controls form-inline">
	            				<label for="inputValue"><font size=4>Год окончания: </font></label>
	            				<input type="text" class="input-small" id="inputValue" name="year">
        					</div>
        				
					</td>
				</tr>
			</table>

			<legend>Контакты</legend>
			<table>
				<tr>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>e-mail 1: </font></label>
	            				<input type="text" class="input-small" id="inputValue" name="email1">
        				  </div>
						
					<td>
				</tr>
				<tr>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>e-mail 2: </font></label>
	            				<input type="text" class="input-small" id="inputValue" name="email2">
        				  </div>
						
					<td>
				</tr>
				<tr>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>телефон: </font></label>
	            				<input type="text" class="input-small" id="inputValue" name="phone">
        				  </div>
						
					<td>
				</tr>
				<tr>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>другие контакты: </font></label>
	            				<input type="text" class="input-small" id="inputValue" name="another_contact">
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
				<tr>
					<td width=10%>
					</td>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>учебный центр/стажировка </font></label>
	            				<select  style="height:27px" class="input-medium" id="inputValue" name="interest_lc">
				  					<option>да</option>
				  					<option>возможно</option>
				  					<option>нет</option>
				  					<option>хочу узнать больше</option>
								</select>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=10%>
					</td>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>работа в компании NetCracker: </font></label>
	            				<select  style="height:27px" class="input-medium" id="inputValue" name="interest_job">
				  					<option>да</option>
				  					<option>возможно</option>
				  					<option>нет</option>
				  					<option>хочу узнать больше</option>
								</select>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td align="left" valign="top" nowrap>
						<font size=4>Интересующая область деятельности </font>
					</td>
				</tr>
				<tr>
					<td width=10%>
					</td>
					<td>
					
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>разработка ПО: </font></label>
	            				<select  style="height:27px" class="input-medium" id="inputValue" name="interest_po">
				  					<option>да</option>
				  					<option>возможно</option>
				  					<option>нет</option>
				  					<option>хочу узнать больше</option>
								</select>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=10%>
					</td>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>другое: </font></label>
	            				<input type="text" class="input-small" id="inputValue" name="interest_another">
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td align="left" valign="top" nowrap>
						<font size=4>Тип работы: </font>
					</td>
				</tr>
				<tr>
					<td width=10%>
					</td>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>глубокая специализация: </font></label>
	            				<select  style="height:27px" class="input-medium" id="inputValue" name="jobtype_gc">
				  					<option>да</option>
				  					<option>возможно</option>
				  					<option>нет</option>
				  					<option>хочу узнать больше</option>
								</select>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=10%>
					</td>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>разнообразная работа: </font></label>
	            				<select  style="height:27px" class="input-medium" id="inputValue" name="jobtype_rj">
				  					<option>да</option>
				  					<option>возможно</option>
				  					<option>нет</option>
				  					<option>хочу узнать больше</option>
								</select>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=10%>
					</td>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>продажи: </font></label>
	            				<select  style="height:27px" class="input-medium" id="inputValue" name="jobtype_sales">
				  					<option>да</option>
				  					<option>возможно</option>
				  					<option>нет</option>
				  					<option>хочу узнать больше</option>
								</select>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=10%>
					</td>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>другое: </font></label>
	            				<input type="text" class="input-small" id="inputValue" name="jobtype_another">
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
					<td width=25% align="left" valign="top">
						
							<div class="controls form-inline">
								<label for="inputValue"><font size=4>C++: </font></label>
								<select  style="height:27px" class="input-small" id="inputValue" name="lan_c">
				  					<option>1</option>
				  					<option>2</option>
				  					<option>3</option>
				  					<option>4</option>
				  					<option>5</option>
								</select>
							</div>
						
					</td>
					<td width=25% align="left" valign="top">
						
							<div class="controls form-inline">
								<label for="inputValue"><font size=4>Java: </font></label>
								<select  style="height:27px" class="input-small" id="inputValue" name="lan_java">
				  					<option>1</option>
				  					<option>2</option>
				  					<option>3</option>
				  					<option>4</option>
				  					<option>5</option>
								</select>
							</div>
						
					</td>
					<td width=25% align="left" valign="top">
						
							<div class="controls form-inline">
								<input type="text" class="input-small" id="inputValue">
								<select  style="height:27px" class="input-small" id="inputValue" name="lan_another1">
				  					<option>1</option>
				  					<option>2</option>
				  					<option>3</option>
				  					<option>4</option>
				  					<option>5</option>
								</select>
							</div>
						
					</td>
					<td width=25% align="left" valign="top">
						
							<div class="controls form-inline">
								<input type="text" class="input-small" id="inputValue">
								<select  style="height:27px" class="input-small" id="inputValue" name="lan_another2">
				  					<option>1</option>
				  					<option>2</option>
				  					<option>3</option>
				  					<option>4</option>
				  					<option>5</option>
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
					<td width=10%>
					</td>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>сетевые технологии: </font></label>
	            				<select  style="height:27px" class="input-small" id="inputValue" name="cs_net">
	            					<option>0</option>
				  					<option>1</option>
				  					<option>2</option>
				  					<option>3</option>
				  					<option>4</option>
				  					<option>5</option>
								</select>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=10%>
					</td>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>эффективные алгоритмы: </font></label>
	            				<select  style="height:27px" class="input-small" id="inputValue">
	            					<option>0</option>
				  					<option>1</option>
				  					<option>2</option>
				  					<option>3</option>
				  					<option>4</option>
				  					<option>5</option>
								</select>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=10%>
					</td>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>ООП: </font></label>
	            				<select  style="height:27px" class="input-small" id="inputValue">
	            					<option>0</option>
				  					<option>1</option>
				  					<option>2</option>
				  					<option>3</option>
				  					<option>4</option>
				  					<option>5</option>
								</select>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=10%>
					</td>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>базы данных: </font></label>
	            				<select  style="height:27px" class="input-small" id="inputValue">
	            					<option>0</option>
				  					<option>1</option>
				  					<option>2</option>
				  					<option>3</option>
				  					<option>4</option>
				  					<option>5</option>
								</select>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=10%>
					</td>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>Web: </font></label>
	            				<select  style="height:27px" class="input-small" id="inputValue">
	            					<option>0</option>
				  					<option>1</option>
				  					<option>2</option>
				  					<option>3</option>
				  					<option>4</option>
				  					<option>5</option>
								</select>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=10%>
					</td>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>графический интерфейс (не Web): </font></label>
	            				<select  style="height:27px" class="input-small" id="inputValue">
	            					<option>0</option>
				  					<option>1</option>
				  					<option>2</option>
				  					<option>3</option>
				  					<option>4</option>
				  					<option>5</option>
								</select>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=10%>
					</td>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>сетевое программирование: </font></label>
	            				<select  style="height:27px" class="input-small" id="inputValue">
	            					<option>0</option>
				  					<option>1</option>
				  					<option>2</option>
				  					<option>3</option>
				  					<option>4</option>
				  					<option>5</option>
								</select>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=10%>
					</td>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>проектирование программ: </font></label>
	            				<select  style="height:27px" class="input-small" id="inputValue">
	            					<option>0</option>
				  					<option>1</option>
				  					<option>2</option>
				  					<option>3</option>
				  					<option>4</option>
				  					<option>5</option>
								</select>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=10%>
					</td>
					<td>
						
						  <div class="controls form-inline">
	            				<input type="text" class="input-small" id="inputValue">
	            				<select  style="height:27px" class="input-small" id="inputValue">
	            					<option>0</option>
				  					<option>1</option>
				  					<option>2</option>
				  					<option>3</option>
				  					<option>4</option>
				  					<option>5</option>
								</select>
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
					<td width=10%>
					</td>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>чтение: </font></label>
	            				<<select  style="height:27px" class="input-small" id="inputValue">
				  					<option>1</option>
				  					<option>2</option>
				  					<option>3</option>
				  					<option>4</option>
				  					<option>5</option>
								</select>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=10%>
					</td>
					<td>
						
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>письмо: </font></label>
	            				<select  style="height:27px" class="input-small" id="inputValue">
				  					<option>1</option>
				  					<option>2</option>
				  					<option>3</option>
				  					<option>4</option>
				  					<option>5</option>
								</select>
        				  </div>
						
					</td>
				</tr>
				<tr>
					<td width=10%>
					</td>
					<td>
					
						  <div class="controls form-inline">
	            				<label for="inputValue"><font size=4>устная речь: </font></label>
	            				<select  style="height:27px" class="input-small" id="inputValue">
				  					<option>1</option>
				  					<option>2</option>
				  					<option>3</option>
				  					<option>4</option>
				  					<option>5</option>
								</select>
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
	            				<label for="inputValue"><font size=4>Откуда ты узнал о наборе в учебный центр?: </font></label>
	            				<select  style="height:27px" class="input-small" id="inputValue">
				  					<option>в интернетах прочитал</option>
				  					<option>друзья рассказали</option>
				  					<option>Бровков посоветовал</option>
				  					<option>флаер увидел</option>
				  					<option>какой учебный центр?</option>
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
						<textarea rows="3"></textarea>
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
						<textarea rows="3"></textarea>
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
						<textarea rows="3"></textarea>
					</td>
				</tr>
			</table>
			<table>
				<tr>	
					<td>
						<input type="submit" style="height:30px; width:300px; font-size: 15px" value="Жми кнопку и почту проверяй">
					</td>
				</tr>
			</table>
		</fieldset>
</form:form>
<br><br><br><br>
<font color="#FF0000" id="error" size="15px">${message }</font>

<%@ include file="/resources/design/footer.jsp" %>