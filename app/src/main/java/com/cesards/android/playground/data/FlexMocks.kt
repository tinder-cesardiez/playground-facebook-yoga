package com.cesards.android.playground.data

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