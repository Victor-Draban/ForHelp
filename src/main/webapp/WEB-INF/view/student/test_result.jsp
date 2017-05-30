<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<h2>Test result</h2>
<div class="sidebar">
	<p>${correct} correct answer of ${allCorrect} questions</p>
	<ul align="left">
		<li style="color: blue">Correct answer: ${correctAnswer} %</li>
		<li style="color: red">Incorrect answer: ${incorrectAnswer} %</li>
	</ul>
	<div>
		<a class="btn btn-success" href="/student/all-test-for-students">All test</a>
	</div>
</div>
