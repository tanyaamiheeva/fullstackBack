package com.fullstack.back.dao.entity;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "schedule")
public class ScheduleEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "userid")
    private Long userid;

    @NotNull
    @Column(name = "weekday")
    private String weekday;

    @Column(name = "first")
    private String first;

    @Column(name = "second")
    private String second;

    @Column(name = "third")
    private String third;

    @Column(name = "fourth")
    private String fourth;

    @Column(name = "fifth")
    private String fifth;

    @Column(name = "sixth")
    private String sixth;

    @Column(name = "seventh")
    private String seventh;
}
