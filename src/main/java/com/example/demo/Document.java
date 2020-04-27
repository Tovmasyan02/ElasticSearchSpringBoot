package com.example.demo;



@org.springframework.data.elasticsearch.annotations.Document(indexName = "my_index", type = "user")
public class Document {
 
  private String id;
  private String docType;
  private String docTitle;

  public Document() {
  }
  
  public Document(String id, String docType, String docTitle){
    this.id = id;
    this.docTitle = docTitle;
    this.docType = docType;
  }
  
  public void setId(String id){
    this.id = id;
  }
  
  public String getId(){
    return this.id;
  }

  @Override
  public String toString() {
    return "Document{" +
        "id='" + id + '\'' +
        ", docType='" + docType + '\'' +
        ", docTitle='" + docTitle + '\'' +
        '}';
  }

  public String getDocType() {
    return docType;
  }

  public void setDocType(String docType) {
    this.docType = docType;
  }

  public String getDocTitle() {
    return docTitle;
  }

  public void setDocTitle(String docTitle) {
    this.docTitle = docTitle;
  }
}
