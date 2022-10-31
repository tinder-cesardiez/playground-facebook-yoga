package com.cesards.android.playground.data

val SAMPLE_I = """
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
                            "flex_direction": "row"
                        },
                        "children": [
                            {
                                "type": "Text",
                                "layout": {
                                    "padding": 4,
                                    "flex_grow": 1
                                },
                                "color": {
                                    "solid": "#FFFFFF"
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
                                    "width": 20,
                                    "height": 20
                                },
                                "color": {
                                    "solid": "#FFFFFF"
                                }
                                "data" : {
                                    "count": 4,
                                    "color": {
                                        "solid": "#aaaaaa"
                                    }
                                }
                            }
                        ]
                    }
                ]
            }
        }
        """
