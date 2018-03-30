//package com.projectside.blogmahasiswa.domain;
//
//import lombok.Data;
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//
//@Data
//@Entity
//public class DetailBerita extends Updatable {
//
//    @Id
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
//    private String id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "berita_id")
//    private Berita berita;
//
//    @Column(name = "content", length = 1000)
//    private String content;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "file_resource_id")
//    private FileResource fileResource;
//
//}
