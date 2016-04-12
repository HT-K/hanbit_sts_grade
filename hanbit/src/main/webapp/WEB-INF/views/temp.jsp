<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
    <form action="">
    	제목 : <input type="text" name="title" id="title" size="20" /> <br />
    	작성자 : <input type="text" name="writerName" id="writerName" /> <br />
    	글암호 : <input type="password" name="password" id="password"/> <br />
    	글내용 : <br />
    	<textarea name="content" id="content" cols="40" rows="5"></textarea> <br />
    	<button id="writeSubmit">전 송</button>
    </form>
    <form>
  <div class="form-group">
    <label for="exampleInputEmail1">제목</label>
    <input type="text" class="form-control" id="title" name="title" placeholder="Email">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">작성자</label>
    <input type="text" class="form-control" id="writerName" name="writerName" placeholder="작성자">
  </div>
  <div class="form-group">
    <label for="exampleInputFile">글암호</label>
    <input type="password" id="password" name="password">
  </div>
  <div class="form-group">
    <label for="exampleInputFile">글내용</label>
    <textarea id="content" name="content" cols="40" rows="5"></textarea>
  </div>
  <button type="submit" id="writeSubmit" class="btn btn-default">전송</button>
</form>
