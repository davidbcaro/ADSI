using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class Instructor
    {
        [Key]
       
        public int idInstructor { get; set; }


        public int id_Document { get; set; }
        public virtual DocumentType DocumentType { get; set; }

        [Display(Name = "numberDocument")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(45, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string numberDocument { get; set; }

        [Display(Name = "Names")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(70, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string Names { get; set; }

        [Display(Name = "lastNames")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(80, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string lastNames { get; set; }


        [Required(ErrorMessage = "El campo es obligatorio")]
        [Display(Name = "Email")]
        [DataType(DataType.EmailAddress)]
        [RegularExpression("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(misena.edu.co||sena.edu.co)$", ErrorMessage = "El correo ingresado debe ser misena.edu.co ó sena.edu.co")]
        public string Email { get; set; }



        public int id_Bonding { get; set; }
        public virtual Bonding Bonding { get; set; }

        public int id_Speciality { get; set; }
        public virtual Speciality Speciality { get; set; }

        [Display(Name = "image")]
        [DataType(DataType.ImageUrl)]
        public string image { get; set; }
        [NotMapped]
        public HttpPostedFileBase PhotoFile { get; set; }

        public virtual ICollection<Schedule> schedule { get; set; }

        [NotMapped]
        public string FullInstructor { get { return string.Format("{0} - {1} {2} - {3} - {4}",  Names,  lastNames, numberDocument, Speciality.speciality_Name, Email); } }

    }
}