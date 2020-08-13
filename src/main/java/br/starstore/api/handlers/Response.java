package br.starstore.api.handlers;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {

	public class ResponseHeader {
		private int code;
		private HttpStatus status;
		private Date date_response;

		public Date getDate_response() {
			return date_response;
		}

		public void setDate_response(Date date_response) {
			this.date_response = date_response;
		}

		public HttpStatus getStatus() {
			return status;
		}

		public void setStatus(HttpStatus status) {
			this.status = status;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}
	}

	public class ResponseData extends ResponseHeader {

		private Object data_response;

		public ResponseData(HttpStatus status, Object data_response) {
			super.code = status.value();
			super.status = status;
			super.date_response = new Date();
			this.setData_response(data_response);
		}

		public Object getData_response() {
			return data_response;
		}

		public void setData_response(Object data_response) {
			this.data_response = data_response;
		}

	}

	public class ResponseError extends ResponseHeader {

		private String error;

		public ResponseError(HttpStatus status, String error) {
			super.code = status.value();
			super.status = status;
			super.date_response = new Date();
			this.error = error;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

	}

	private ResponseData responseUtil(HttpStatus status, Object data) {
		return new ResponseData(status, data);
	}
	
	private ResponseError errorUtil(HttpStatus status,String erro) {
		return new ResponseError(status, erro);
	}

	public ResponseEntity<?> sucefull(Object data) {
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<ResponseData>(responseUtil(status, data), status);
	};
	
	public ResponseEntity<?> sucefullResults(List<Object> data) {
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<ResponseData>(responseUtil(status, data), status);
	};


	public ResponseEntity<?> created(Object data) {
		HttpStatus status = HttpStatus.CREATED;
		return new ResponseEntity<ResponseData>(responseUtil(status, data), status);
	};


	
	public ResponseEntity<?> acessDenied(String error) {
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		return new ResponseEntity<ResponseError>(errorUtil(status,error), status);
	};
	
	public ResponseEntity<?> alreadyExists(String error) {
		HttpStatus status = HttpStatus.CONFLICT;
		return new ResponseEntity<ResponseError>(errorUtil(status,error), status);
	};
	
	public ResponseEntity<?> invalidParams(String error) {
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		return new ResponseEntity<ResponseError>(errorUtil(status,error), status);
	};
	
	public ResponseEntity<?> notFound(String error) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		return new ResponseEntity<ResponseError>(errorUtil(status,error), status);
	};

}
