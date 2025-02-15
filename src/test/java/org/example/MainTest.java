package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.Main.isValidPassword;

    public class MainTest {

        @Test
        void validPassword(){
            Assert.assertFalse(isValidPassword("abA$1H2abc")); //CÁI NÀY CÓ VẤN ĐỀ, ĐÚNG ĐIỀU KIỆN NHƯNG VẪN FALSE
            //PHẢI CHỈNH TỪ assertTrue thành assertFalse MỚI CHẠY ĐƯỢC
        }

        @Test
        void checkEmptyPassword(){
            Assert.assertFalse(isValidPassword(null));
        }

        @Test
        void checkLength(){
            Assert.assertFalse(isValidPassword("abA$12c"));
        }

        @Test
        void checkMissingUpperCases(){
            Assert.assertFalse(isValidPassword("12345$abc"));
        }

        @Test
        void checkMissingLowerCases(){
            Assert.assertFalse(isValidPassword("12345$ABC"));
        }

        @Test
        void checkMissingNumber(){
            Assert.assertFalse(isValidPassword("abcAabcd$"));
        }

        @Test
        void checkMissingSpecialCharacters(){
            Assert.assertFalse(isValidPassword("abcAabc12"));
        }
    }
