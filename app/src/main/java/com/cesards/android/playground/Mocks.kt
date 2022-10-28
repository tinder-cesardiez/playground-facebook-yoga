package com.cesards.android.playground

import android.graphics.Color

// **********************************************************
// ********* FLEXBOX SIMPLE ATTRIBUTE SETUP TESTING *********
// **********************************************************

// https://reactnative.dev/docs/flexbox#flex
// Observations:
// - Flex (flex_grow) behavior works as expected.
val SAMPLE_FLEX = """
        {
            "id" : "template_2",
            "value" : {
                "type": "Box",
                "layout": {
                    "flex_direction" : "column",
                    "width": 900,
                    "height": 900,
                    "padding" : 20
                },
                "children": [
                    {
                        "type": "Box",
                        "layout": {
                            "flex_grow" : 1
                        },
                        "data" : {
                            "color": {
                                "solid": "#880808"
                            }
                        }
                    },
                    {
                        "type": "Box",
                        "layout": {
                            "flex_grow" : 2
                        },
                        "data" : {
                            "color": {
                                "solid": "#ff8c00"
                            }
                        }
                    },
                    {
                        "type": "Box",
                        "layout": {
                            "flex_grow" : 3
                        },
                        "data" : {
                            "color": {
                                "solid": "#00FF00"
                            }
                        }
                    }
                ]
            }
        }
        """

// https://reactnative.dev/docs/flexbox#flex-direction
// Observations:
// - "column" direction works as expected.
// - "row" direction works as expected.
// - "column-reverse" direction works as expected.
// - "row-reverse" direction works as expected.
fun FLEX_DIRECTION(direction: String) :String {
    if (direction != "row" && direction != "row-reverse" && direction != "column" && direction != "column-reverse") {
        error("Direction type not supported.")
    }

    return """
        {
            "id" : "template_2",
            "value" : {
                "type": "Box",
                "layout": {
                    "flex_direction" : "$direction",
                    "width": 900,
                    "height": 900,
                    "padding" : 20
                },
                "data" : {
                    "color": {
                        "solid": "#F0F8FF"
                    }
                },
                "children": [
                    {
                        "type": "Box",
                        "layout": {
                            "width": 100,
                            "height": 100
                        },
                        "data" : {
                            "color": {
                                "solid": "#B0E0E6"
                            }
                        }
                    },
                    {
                        "type": "Box",
                        "layout": {
                            "width": 100,
                            "height": 100
                        },
                        "data" : {
                            "color": {
                                "solid": "#87CEEB"
                            }
                        }
                    },
                    {
                        "type": "Box",
                        "layout": {
                            "width": 100,
                            "height": 100
                        },
                        "data" : {
                            "color": {
                                "solid": "#4682B4"
                            }
                        }
                    }
                ]
            }
        }
        """
}

// https://reactnative.dev/docs/flexbox#layout-direction
// Skipped

// https://reactnative.dev/docs/flexbox#justify-content
// Skipped

// https://reactnative.dev/docs/flexbox#absolute--relative-layout
// Observations:
// - "absolute" position works as expected.
// - "relative" position works as expected.
fun POSITION(position: String) :String {
    if (position != "relative" && position != "absolute") {
        error("Direction type not supported.")
    }

    return """
        {
            "id" : "template_2",
            "value" : {
                "type": "Box",
                "layout": {
                    "padding" : 20
                },
                "data" : {
                    "color": {
                        "solid": "#F0F8FF"
                    }
                },
                "children": [
                    {
                        "type": "Box",
                        "layout": {
                            "position": "$position",
                            "width": 150,
                            "height": 150,
                            "top": 25,
                            "left": 25
                        },
                        "data" : {
                            "color": {
                                "solid": "#B0E0E6"
                            }
                        }
                    },
                    {
                        "type": "Box",
                        "layout": {
                            "position": "$position",
                            "width": 150,
                            "height": 150,
                            "top": 50,
                            "left": 50
                        },
                        "data" : {
                            "color": {
                                "solid": "#87CEEB"
                            }
                        }
                    },
                    {
                        "type": "Box",
                        "layout": {
                            "position": "$position",
                            "width": 150,
                            "height": 150,
                            "top": 75,
                            "left": 75
                        },
                        "data" : {
                            "color": {
                                "solid": "#4682B4"
                            }
                        }
                    }
                ]
            }
        }
        """
}

// *********************************************
// ********* COMPLEX STRUCTURE TESTING *********
// *********************************************

// Sample 1 from https://yogalayout.com/
// Image path: /extra/sample-complex-1.png
// export default class MyLayout extends Component {
//     render() {
//         return (
//         <View style={{
//             flex: 1,
//             width: 500,
//             height: 500,
//             alignItems: 'flex-start',
//             padding: 20,
//             }}>
//                 <View style={{
//                     flex: 1,
//                     width: 100,
//                     height: 100,
//             }} />
//                 <View style={{
//                     flex: 1,
//                     width: 200,
//                     height: 200,
//                     justifyContent: 'space-between',
//                     alignItems: 'flex-end',
//                     alignSelf: 'flex-end',
//                     marginHorizontal: 20,
//                     flexGrow: 1,
//                    }}>
//                        <View style={{
//                            flex: 1,
//                            width: 100,
//                            height: 100,
//                           }} />
//                        <View style={{
//                            flex: 1,
//                            width: 100,
//                            height: 100,
//                    }} />
//                        </View>
//                  <View style={{
//                      flex: 1,
//                      width: 100,
//                      height: 100,
//            }} />
//                </View>
//                );
//     }
// };
val SAMPLE_COMPLEX_1 : String = """
        {
            "id": "template_2",
            "value": {
                "type": "Box",
                "layout": {
                    "flex_direction": "row",
                    "align_items": "flex-start",
                    "padding": 20,
                    "width": 600,
                    "height": 600
                },
                "data": {
                    "color": {
                        "solid": "#F0F8FF"
                    }
                },
                "children": [{
                        "type": "Text",
                        "layout": {
                            "width": 100,
                            "height": 100
                        },
                        "data": {
                            "color": {
                                "solid": "#87CEEB"
                            }
                        }
                    },
                    {
                        "type": "Box",
                        "layout": {
                            "justify_content": "space-between",
                            "align_items": "flex-end",
                            "align_self": "flex-end",
                            "flex_direction": "row",
                            "margin": 20,
                            "width": 300,
                            "height": 300
                        },
                        "data": {
                            "color": {
                                "solid": "#B0E0E6"
                            }
                        },
                        "children": [{
                                "type": "Text",
                                "layout": {
                                    "width": 100,
                                    "height": 100
                                },
                                "data": {
                                    "color": {
                                        "solid": "#cdba4a"
                                    }
                                }
                            },
                            {
                                "type": "Text",
                                "layout": {
                                    "width": 100,
                                    "height": 100
                                },
                                "data": {
                                    "color": {
                                        "solid": "#87a4c3"
                                    }
                                }
                            }
                        ]
                    },
                    {
                        "type": "Text",
                        "layout": {
                            "width": 100,
                            "height": 100
                        },
                        "data": {
                            "color": {
                                "solid": "#4682B4"
                            }
                        }
                    }
                ]
            }
        }
        """












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
                                    "padding": 20,
                                    "width": 100,
                                    "height": 60
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
                                "font_size": 20,
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
                        "children": [
                            {
                                "type": "Text",
                                "layout": {
                                    "flex_grow": 1,
                                    "justify_content": "center",
                                    "align_items": "center",
                                    "padding": 10,
                                    "margin": 10,
                                    "white_space": "nowrap"
                                },
                                "data" : {
                                    "text" : {
                                        "body": "Upgrade",
                                        "color": {
                                            "solid": "#ffffff"
                                        },
                                        "font_size": 22,
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
                                    "width": 400,
                                    "height": 100,
                                    "flex_grow": 1,
                                    "justify_content": "center",
                                    "align_items": "center",
                                    "padding": 10,
                                    "margin": 10,
                                    "white_space": "nowrap"
                                },
                                "data" : {
                                    "text": {
                                        "body": "Compare all Plans",
                                        "color": {
                                            "solid": "#000000"
                                        },
                                        "font_size": 22,
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




val COLORS = listOf(
    Color.parseColor("#ff33b5e5"),
    Color.parseColor("#33999999"),
    Color.parseColor("#ff99cc00"),
    Color.parseColor("#ff0099cc"),
    Color.parseColor("#ff669900"),
    Color.parseColor("#ffcc0000"),
    Color.parseColor("#ffaa66cc"),
    Color.parseColor("#ffffbb33"),
    Color.parseColor("#ffff8800"),
    Color.parseColor("#ff00ddff"),
    Color.parseColor("#33CCCCCC"),
    Color.parseColor("#ff222222"),
    Color.parseColor("#39cccccc"),
    Color.parseColor("#59f0f0f0"),
    Color.parseColor("#ffe6e6e6"),
    Color.parseColor("#dacccccc"),
    Color.parseColor("#66666666"),
    Color.parseColor("#b3cccccc"),
    Color.parseColor("#2699cc00"),
    Color.parseColor("#46c5c1ff"),
    Color.parseColor("#4699cc00"),

)