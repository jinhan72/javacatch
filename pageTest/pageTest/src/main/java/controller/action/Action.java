package controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	// public abstract ���� ���� -> �����Ͽ��� �ڵ� ����
	ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException;
	// �Ķ���ͷ� response, request�� �޾� page�� ����
	// ������ ���(path)�� ������ ���޹��(redirect)�� �ʿ��ϹǷ� �� ���� �ʵ�� ���� ActionForward Ŭ������ ����� ����!
}