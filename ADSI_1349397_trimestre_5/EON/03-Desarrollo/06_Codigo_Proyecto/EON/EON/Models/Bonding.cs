using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class Bonding
    {
        [Key]
        [Display(Name = "Bonding")]
        public int id_Bonding { get; set; }


        [Display(Name = "Type Linkage")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(100, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string Type_Linkage { get; set; }


        [Display(Name = "Hour Start")]
        [Required(ErrorMessage = "Field {0} is required")]
        [DataType(DataType.Time)]
        [DisplayFormat(DataFormatString = "{0:HH:mm}", ApplyFormatInEditMode = true)]
        public System.DateTime hour_Start { get; set; }

        [Display(Name = "Hours end")]
        [Required(ErrorMessage = "Field {0} is required")]
        [DataType(DataType.Time)]
        [DisplayFormat(DataFormatString = "{0:HH:mm}", ApplyFormatInEditMode = true)]
        public System.DateTime hours_End { get; set; }


        [Display(Name = "Status")]
        public bool Status { get; set; }

        public virtual ICollection<Instructor> Instructor { get; set; }

    }


}