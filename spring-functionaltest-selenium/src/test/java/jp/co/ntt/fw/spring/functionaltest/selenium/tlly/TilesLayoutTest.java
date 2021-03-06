/*
 * Copyright(c) 2014-2017 NTT Corporation.
 */
package jp.co.ntt.fw.spring.functionaltest.selenium.tlly;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
import static org.openqa.selenium.By.id;

import java.io.IOException;

import jp.co.ntt.fw.spring.functionaltest.selenium.FunctionTestSupport;

import org.junit.Test;
import org.openqa.selenium.By;

public class TilesLayoutTest extends FunctionTestSupport {

    /**
     * <ul>
     * <li>Tilesレイアウトを適用するパスにリクエストした場合、定義したレイアウトが有効になることを確認する。</li>
     * </ul>
     */
    @Test
    public void testTLLY0101001() throws IOException {

        // メニュー画面の操作
        {
            webDriverOperations.click(id("tlly0101001"));
        }

        // デフォルトレイアウトの確認（タイトル固定、X-Trackあり）
        {
            assertThat(webDriverOperations.getTitle(),
                    is("Spring Functional Test"));
            assertThat(webDriverOperations.getText(id("bodyTitle")),
                    is("Register Staff Information"));
            assertThat(webDriverOperations.getXTrack(), not(""));
        }

    }

    /**
     * <ul>
     * <li>Tilesレイアウトを適用していないパスにリクエストした場合、定義したレイアウトが有効にならないことを確認する。</li>
     * </ul>
     */
    @Test
    public void testTLLY0102001() throws IOException {

        // メニュー画面の操作
        {
            webDriverOperations.click(id("tlly0102001"));
        }

        // レイアウト未適応の確認（X-Trackなし）
        {
            assertThat(webDriverOperations.getTitle(),
                    is("Spring Functional Test"));
            assertThat(webDriverOperations.getText(id("bodyTitle")),
                    is("Delete Staff Information"));

            By idOfXTrack = webDriverOperations.getIdOfXTrack();
            assertFalse(webDriverOperations.exists(idOfXTrack));

        }

    }

    /**
     * <ul>
     * <li>Tilesの定義ファイルに、複数のレイアウトが定義されている場合、URLのパターンでレイアウトを振り分けることができることを確認する。</li>
     * </ul>
     */
    @Test
    public void testTLLY0201001() throws IOException {

        // メニュー画面の操作
        {
            webDriverOperations.click(id("tlly0201001"));
        }

        // 複数レイアウト定義時の一つ目適応確認（タイトル固定、X-Trackあり）
        {
            assertThat(webDriverOperations.getTitle(),
                    is("Update Staff Information (TLLY template is valid.)"));
            assertThat(webDriverOperations.getText(id("bodyTitle")),
                    is("Update Staff Information"));
            assertThat(webDriverOperations.getXTrack(), not(""));
        }

    }

    /**
     * <ul>
     * <li>Tilesの定義ファイルに、複数のレイアウトが定義されている場合、URLのパターンでレイアウトを振り分けることができることを確認する。</li>
     * </ul>
     */
    @Test
    public void testTLLY0201002() throws IOException {

        // メニュー画面の操作
        {
            webDriverOperations.click(id("tlly0201002"));
        }

        // 複数レイアウト定義時の二つ目適応確認（タイトル固定、X-Trackあり）
        {
            assertThat(webDriverOperations.getTitle(),
                    is("Search Staff Information (TLLY template is valid.)"));
            assertThat(webDriverOperations.getText(id("bodyTitle")),
                    is("Search Staff Information"));
            assertThat(webDriverOperations.getXTrack(), not(""));
        }

    }

    /**
     * <ul>
     * <li>Tilesの定義ファイルに、複数のレイアウトが定義されている場合、Tilesの定義ファイルに記述した順番で、 最初にURLパターンにマッチするレイアウトが使用されることを確認する。</li>
     * </ul>
     */
    @Test
    public void testTLLY0202001() throws IOException {

        // メニュー画面の操作
        {
            webDriverOperations.click(id("tlly0202001"));
        }

        // 複数レイアウト定義時の一つ目適応確認（タイトル固定、X-Trackあり）
        {
            assertThat(webDriverOperations.getTitle(),
                    is("Update Staff Information (TLLY template is valid.)"));
            assertThat(webDriverOperations.getText(id("bodyTitle")),
                    is("Update Staff Information"));
            assertThat(webDriverOperations.getXTrack(), not(""));
        }

    }

}
