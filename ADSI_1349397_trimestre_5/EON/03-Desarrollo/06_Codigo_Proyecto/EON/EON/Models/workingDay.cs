using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class workingDay
    {
        [Key]
        [Display(Name = " working Day")]
        public int id_working_Day { get; set; }

        [Display(Name = "acronymsWorkingDay")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(20, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string acronyms_Working_day { get; set; }

        [Display(Name = "Name")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(50, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string Name { get; set; }

        [Display(Name = "Description")]
        [DataType(DataType.MultilineText)]
        [StringLength(45, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string Description { get; set; }

        [Display(Name = "image")]
        [DataType(DataType.ImageUrl)]
        public string image { get; set; }
        [NotMapped]
        public HttpPostedFileBase PhotoFile { get; set; }


        [Display(Name = "Status")]
        public bool Status { get; set; }

        public virtual ICollection<Availability> Availability { get; set; }

        public virtual ICollection<Trimester> Trimester { get; set; }
    }
}