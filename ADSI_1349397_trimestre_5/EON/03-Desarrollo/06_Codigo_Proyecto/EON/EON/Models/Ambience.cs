using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class Ambience
    {
        [Key]
        [Display(Name = "idAmbience")]
        public int id_Ambience { get; set; }

        [Display(Name = "numberAmbience")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(10, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string number_Ambience { get; set; }

        [Display(Name = "Description")]
        [StringLength(100, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        [DataType(DataType.MultilineText)]
        public string Description { get; set; }

        [Display(Name = "Status")]
        public bool Status { get; set; }

        public virtual ICollection<Schedule> schedule { get; set; }
        [NotMapped]
        public string FullAmbience { get { return string.Format("{0} - {1} - {2}", Headquarters.name_Headquarters, Headquarters.Address, number_Ambience); } }

        public int id_Headquarters { get; set; }
        public virtual Headquarters Headquarters { get; set; }
    }
}