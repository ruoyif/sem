//
//  ViewController.swift
//  MaLa
//
//  Created by F Zoey. on 2019/9/12.
//  Copyright © 2019 F Zoey. All rights reserved.
//

import UIKit
import MapKit
import SafariServices

class ViewController: UIViewController {

    @IBOutlet weak var mapView: MKMapView!
    @IBAction func webButton(_ sender: UIButton) {
        let myUrl = URL(string: "https://www.youtube.com/results?search_query=hotpot")!
        let safariVC = SFSafariViewController(url: myUrl)
        present(safariVC, animated: true)
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        let centerLocation = CLLocationCoordinate2DMake(37.307330,-122.011700)
        let annotation = MKPointAnnotation()
        annotation.title = "MaLa Hot Pot"
        annotation.subtitle = "Chinese Resturant"
        annotation.coordinate = centerLocation
        self.mapView.showAnnotations([annotation], animated: true)
        self.mapView.selectAnnotation(annotation, animated: true)

    }


}

