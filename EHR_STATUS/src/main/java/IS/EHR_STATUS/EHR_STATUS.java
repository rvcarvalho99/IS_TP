package IS.EHR_STATUS;

public class EHR_STATUS {

    public String _type;
    public UID uid;
    public boolean is_queryable;
    public boolean is_modifiable;

}





/*
*

  "other_details": {
    "_type": "ITEM_TREE",
    "items": [
      {
        "_type": "CLUSTER",
        "archetype_details": {
          "_type": "ARCHETYPED"
        },
        "items": [
          {
            "_type": "ELEMENT",
            "name": {
              "_type": "DV_TEXT",
              "value": "Administrative Gender"
            },
            "archetype_node_id": "at0001",
            "value": {
              "_type": "DV_CODED_TEXT",
              "value": "FEMALE",
              "defining_code": {
                "_type": "CODE_PHRASE",
                "terminology_id": {
                  "_type": "TERMINOLOGY_ID",
                  "value": "local"
                },
                "code_string": "at0010"
              }
            }
          },
          {
            "_type": "ELEMENT",
            "name": {
              "_type": "DV_TEXT",
              "value": "Birth Sex"
            },
            "archetype_node_id": "at0002",
            "value": {
              "_type": "DV_CODED_TEXT",
              "value": "FEMALE",
              "defining_code": {
                "_type": "CODE_PHRASE",
                "terminology_id": {
                  "_type": "TERMINOLOGY_ID",
                  "value": "local"
                },
                "code_string": "at0010"
              }
            }
          },
          {
            "_type": "ELEMENT",
            "name": {
              "_type": "DV_TEXT",
              "value": "Vital Status"
            },
            "archetype_node_id": "at0003",
            "value": {
              "_type": "DV_CODED_TEXT",
              "value": "Alive",
              "defining_code": {
                "_type": "CODE_PHRASE",
                "terminology_id": {
                  "_type": "TERMINOLOGY_ID",
                  "value": "local"
                },
                "code_string": "at0004"
              }
            }
          },
          {
            "_type": "ELEMENT",
            "name": {
              "_type": "DV_TEXT",
              "value": "Birth Year"
            },
            "archetype_node_id": "at0014",
            "value": {
              "_type": "DV_COUNT",
              "magnitude": 1976
            }
          }
        ]
      },
      {
        "_type": "ELEMENT",
        "archetype_node_id": "at0001",
        "value": {
          "_type": "DV_CODED_TEXT",
          "value": "FEMALE",
          "defining_code": {
            "_type": "CODE_PHRASE",
            "terminology_id": {
              "_type": "TERMINOLOGY_ID",
              "value": "local"
            },
            "code_string": "F"
          }
        }
      },
      {
        "_type": "ELEMENT",
        "archetype_node_id": "at0002",
        "value": {
          "_type": "DV_DATE_TIME",
          "value": "1976-07-01T14:35:00.000+01:00"
        }
      }
    ]
  }
}
* */