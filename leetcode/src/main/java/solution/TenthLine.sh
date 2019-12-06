#!/usr/bin/env bash
# leetcode-195-第十行
index=1;
cat file.txt | while read LINE
do
    if [ $index -eq 10 ];then
        echo $LINE
    fi
    let index=index+1
done
