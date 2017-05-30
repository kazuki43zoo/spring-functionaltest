/*
 * Copyright(c) 2014-2017 NTT Corporation.
 */
package jp.co.ntt.fw.spring.functionaltest.ws.soap.wsimport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * todo complex typeのJavaクラス。
 * <p>
 * 次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="todo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createdAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="finished" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="todoId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "todo", propOrder = { "createdAt", "description", "finished",
        "title", "todoId" })
public class Todo {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdAt;

    protected String description;

    protected boolean finished;

    protected String title;

    protected String todoId;

    /**
     * createdAtプロパティの値を取得します。
     * @return possible object is {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getCreatedAt() {
        return createdAt;
    }

    /**
     * createdAtプロパティの値を設定します。
     * @param value allowed object is {@link XMLGregorianCalendar }
     */
    public void setCreatedAt(XMLGregorianCalendar value) {
        this.createdAt = value;
    }

    /**
     * descriptionプロパティの値を取得します。
     * @return possible object is {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * descriptionプロパティの値を設定します。
     * @param value allowed object is {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * finishedプロパティの値を取得します。
     */
    public boolean isFinished() {
        return finished;
    }

    /**
     * finishedプロパティの値を設定します。
     */
    public void setFinished(boolean value) {
        this.finished = value;
    }

    /**
     * titleプロパティの値を取得します。
     * @return possible object is {@link String }
     */
    public String getTitle() {
        return title;
    }

    /**
     * titleプロパティの値を設定します。
     * @param value allowed object is {@link String }
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * todoIdプロパティの値を取得します。
     * @return possible object is {@link String }
     */
    public String getTodoId() {
        return todoId;
    }

    /**
     * todoIdプロパティの値を設定します。
     * @param value allowed object is {@link String }
     */
    public void setTodoId(String value) {
        this.todoId = value;
    }

}