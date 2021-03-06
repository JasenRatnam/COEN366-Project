package Responses;

import Requests.Request;

//import java.io.Serial;

public class FileEnd extends Request {

    //@Serial
    private static final long serialVersionUID = 1L;
    private String fileName;
    private int chunkNumb;
    private String text;

    /**
     * contstructor of a response for a download response
     * If the file exists at destination, the peer will start transferring the file in small chunks not
     * exceeding 200 characters using the following message (where Chunk# indicates the
     * order/place of the Text in the original file).
     */
    public FileEnd(int rqNumber, String fileName, int chunkNumb, String text) {
        super(Request.RequestType.FILE_END, rqNumber);
        this.fileName = fileName;
        this.chunkNumb = chunkNumb;
        this.text = text;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getChunkNumb() {
        return chunkNumb;
    }

    public void setChunkNumb(int chunkNumb) {
        this.chunkNumb = chunkNumb;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //print the response
    @Override
    public String toString() {
        return Request.RequestType.FILE_END + " " + this.getRQNumb() + " " + getFileName()
                + " " + getChunkNumb() + "\nText:\n '" + getText() + "'";
    }
}
