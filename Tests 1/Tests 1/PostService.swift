//
//  Untitled.swift
//  Tests 1
//
//  Created by 김민준 on 6/15/26.
//

import Foundation

final class PostService {

    func getPosts(completion: @escaping ([PostDTO]) -> Void) {
        guard let url = URL(string: "https://jsonplaceholder.typicode.com/posts") else {
            return
        }

        URLSession.shared.dataTask(with: url) { data, response, error in
            if let error {
                print(error)
                return
            }

            if let httpResponse = response as? HTTPURLResponse {
                print("상태코드:", httpResponse.statusCode)
            }

            guard let realData = data else {
                return
            }

            do {
                let posts = try JSONDecoder().decode([PostDTO].self, from: realData)
                completion(posts)
            } catch {
                print(error)
            }
        }.resume()
    }
}

// https://jsonplaceholder.typicode.com/posts 200
// https://jsonplaceholder.typicode.com/postss 404
