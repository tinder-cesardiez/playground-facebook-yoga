package com.cesards.android.playground


// *********************************************
// ********* COMPLEX STRUCTURE TESTING *********
// *********************************************


// https://developer.mozilla.org/en-US/docs/Web/CSS/flex
// https://github.com/facebook/yoga/issues/181
// The following resource is great:
// https://reactnative.dev/docs/flexbox

// flex = flex_grow
val SAMPLE_1_STRUCT = """
        {
            "id" : "template_2",
            "layout": "flexbox",
            "display": "flexbox",
            "value" : {
                "type": "Box",
                "layout": {
                    "flex_grow" : 10,
                    "align_items": "flex-start",
                    "width": 900,
                    "height": 900,
                    "padding" : 20
                },
                "children": [
                    {
                        "type": "Box",
                        "layout": {
                            "flex_grow" : 1,
                            "width": 100,
                            "height": 100,
                            "margin": 20
                        }
                    }
                ]
            }
        }
        """
// GOTCHAS:
// - Using "align_items" attribute works as expected.
// - Specifying "flex_grow" : 1 will expand the height (in this case) no matter what, even if we chose "height" : 100.
//
//   "layout": {
//       "flex_grow" : 1,
//       "width": 100,
//       "height": 100,
//       "margin": 20
//   }






// layout, display
// previous values are only shown once?
// Based on https://github.com/TinderApp/tinder_ios/blob/526fecb4b0210052fafc8877256bb58abeb39d7d/Projects/Examples/SDUIExample/Source/Stubs/Fixtures/SDUI.json
// and https://github.com/TinderApp/tinder_ios/pull/36063/files#diff-81e15224eb5b811bc66fbdc27960e2ba82fff653d6466334a5296ea3dd8fabe4R282-R284
val CONTROLLA_SAMPLE_STRUCT = """
        {
            "id" : "template_1",
            "value" : {
                "type": "Box",
                "layout": {
                    "flex_direction": "column",
                    "justify_content": "start"
                },
                "children": [
                    {
                        "type": "Box",
                        "layout": {
                            "position": "absolute",
                            "top": 0,
                            "right": 0,
                            "bottom": 0,
                            "left": 0
                        },
                        "data" : {
                            "color": {
                                "solid": "#FFFFFF"
                            },
                            "border": {
                                "radius": 20
                            }
                        }
                    },
                    {
                        "type": "Box",
                        "layout": {
                            "flex_direction": "row"
                        },
                        "children": [
                            {
                                "type": "Text",
                                "layout": {
                                    "padding": 20,
                                    "flex_grow": 1
                                },
                                "data" : {
                                    "text": {
                                        "body": "Curated Just for you",
                                        "font_size": 16,
                                        "color": {
                                            "solid": "#000000"
                                        }
                                    }
                                }
                            },
                            {
                                "type": "CarouselBars",
                                "layout": {
                                    "padding": 6,
                                    "width": 100,
                                    "height": 20
                                },
                                "data" : {
                                    "count": 4,
                                    "color": {
                                        "solid": "#aaaaaa"
                                    }
                                }
                            }
                        ]
                    },
                    {
                        "type": "Image",
                        "layout": {
                            "width": 187,
                            "height": 37,
                            "padding": 10
                        },
                        "data" : {
                            "media": {
                                "url": "/images/tinder_plus_logo.png",
                                "mime_type": "image/png"
                            },
                            "color": {
                                "solid": "#378cac"
                            }
                        }
                    },
                    {
                        "type": "Text",
                        "layout": {
                            "flex_grow": 1,
                            "margin": 20
                        },
                        "data" : {
                            "text" : {
                                "font_size": 16,
                                "body": "✓ Unlimited Right Swipes\n✓ Unlimited Likes\n✓ Unlimited Rewinds... and more!",
                                "color": {
                                    "solid": "#000000"
                                }
                            }
                        }
                    },
                    {
                        "type": "Box",
                        "layout": {
                            "flex_direction": "row",
                            "justify_content": "start",
                            "justify_items": "stretch",
                            "margin": 10
                        },
                         "data" : {
                            "color": {
                                "solid": "#CAD123"
                            }
                        },
                        "children": [
                            {
                                "type": "Text",
                                "layout": {
                                    "flex_grow": 1,
                                    "justify_content": "center",
                                    "align_items": "center",
                                    "white_space": "nowrap"
                                },
                                "data" : {
                                    "text" : {
                                        "body": "Upgrade",
                                        "color": {
                                            "solid": "#ffffff"
                                        },
                                        "font_size": 16,
                                        "font_weight": "semibold"
                                    },
                                    "border": {
                                        "radius": 20
                                    },
                                    "color": {
                                        "solid": "#ff0000"
                                    }
                                }
                            },
                            {
                                "type": "Text",
                                "layout": {
                                    "flex_grow": 1,
                                    "justify_content": "center",
                                    "align_items": "center",
                                    "white_space": "nowrap"
                                },
                                "data" : {
                                    "text": {
                                        "body": "Compare all Plans",
                                        "color": {
                                            "solid": "#000000"
                                        },
                                        "font_size": 16,
                                        "font_weight": "semibold"
                                    },
                                    "border": {
                                        "radius": 20,
                                        "width": 2.0,
                                        "color": {
                                            "solid": "#999999"
                                        }
                                    }
                                }
                            }
                        ]
                    }
                ]
            }
        }
        """
