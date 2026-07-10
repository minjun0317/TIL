//
//  ContentView.swift
//  Tests 2
//
//  Created by 김민준 on 6/16/26.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundStyle(.tint)
            Text("Hello, world!")
        }
        .padding()
        .onAppear {
            PostService().getPosts { _ in }
        }
    }
}

#Preview {
    ContentView()
}
