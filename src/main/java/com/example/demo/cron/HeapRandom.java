package com.example.demo.cron;

import java.util.*;

public class HeapRandom {

    static final int N = 10;

    public static void main(String[] args) {

        Random random = new Random();


        int [] arr = new int[N];


        for (int i = 0; i < N; i++) {
            // 0 ~ 99
            arr[i] = random.nextInt(100);

        }


        System.out.println("정렬 하기 전"+ arr);


        heapSort(arr);
        System.out.println("정렬 후" + arr);

    }

    public static void heapSort(int[] arr) {

        int n = arr.length;

        // 제일 큰 힙을 구성한다
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i); // 일반 배열을 힙으로 구성
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0); // 요소를 제거한 뒤 다시 최대힙을 구성
        }
    }

    // 배열을 heap 자료구조로 만듬
    private static void heapify(int[] arr, int n, int i) {

        int parent = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        // 왼쪽 자식노드
        if (left < n && arr[parent] < arr[left])
            parent = left;
        // 오른쪽 자식노드
        if (right < n && arr[parent] < arr[right])
            parent = right;

        // 부모노드 < 자식노드
        if (i != parent) {
            swap(arr, parent, i);
            heapify(arr, n, parent);
        }
    }


    // 노드 위치 변경
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}







