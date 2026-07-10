//
//  PostDTO.swift
//  Tests 2
//
//  Created by 김민준 on 6/16/26.
//

import Foundation

struct PostDTO: Codable {
    var userId: Int
    var id: Int
    var title: String
    var body: String
}
