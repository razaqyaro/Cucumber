Feature: Search and Place the order for Products

Scenario:  Search Experience for product search in both Home and Offers page
  Given User is on GreenCart Landing page
  When User searched with shortname "Tom" and extracted actual name of product
  Then User searched for same "Tom" in offers page
  And Validate product name in landing page matches with that on landing page