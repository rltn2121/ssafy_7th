package board.dto;

import java.time.LocalDateTime;
import java.util.List;

public class BoardFileDto {
	private int fileId;
	private int boardId;
	private String fileName;
	private long fileSize;
	private String fileContentType;
	private String fileUrl;
	private LocalDateTime regDt;
	
	// file upload
	private List<BoardFileDto> fileList;

	@Override
	public String toString() {
		return "BoardFileDto [fileId=" + fileId + ", boardId=" + boardId + ", fileName=" + fileName + ", fileSize="
				+ fileSize + ", fileContentType=" + fileContentType + ", fileUrl=" + fileUrl + ", regDt=" + regDt
				+ ", fileList=" + fileList + "]";
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public LocalDateTime getRegDt() {
		return regDt;
	}

	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}

	public List<BoardFileDto> getFileList() {
		return fileList;
	}

	public void setFileList(List<BoardFileDto> fileList) {
		this.fileList = fileList;
	}
}
