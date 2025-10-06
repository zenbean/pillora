//
//  Item.swift
//  Medication Tracking App
//
//  Created by Thomas Flintoff on 21/08/2025.
//

import Foundation
import SwiftData

@Model
final class Item {
    var timestamp: Date
    
    init(timestamp: Date) {
        self.timestamp = timestamp
    }
}
