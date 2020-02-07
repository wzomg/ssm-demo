package com.zzw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    // 字段名尽量和数据库保持一致
    private int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;
}
