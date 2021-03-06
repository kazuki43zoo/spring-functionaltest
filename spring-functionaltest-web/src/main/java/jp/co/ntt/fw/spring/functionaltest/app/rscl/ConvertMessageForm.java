/*
 * Copyright(c) 2014-2017 NTT Corporation.
 */
/**
 * 
 */
package jp.co.ntt.fw.spring.functionaltest.app.rscl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

/**
 * <ul>
 * <li>RequestFormのクラス。</li> <br>
 * </ul>
 */
public class ConvertMessageForm implements Serializable {

    /**
     * シリアルID
     */
    private static final long serialVersionUID = 1L;

    /**
     * リクエストパス
     */
    private String pass;

    /**
     * 名前
     */
    @XmlElement
    private String name;

    /**
     * 年齢
     */
    @XmlElement
    private int age;

    /**
     * メッセージ
     */
    private String message;

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
